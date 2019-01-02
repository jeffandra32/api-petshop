package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.servico.Categoria;
import com.api.zoobook.restapizoobook.domain.servico.Produto;
import com.api.zoobook.restapizoobook.dto.ProdutoDTO;
import com.api.zoobook.restapizoobook.repositores.CategoriaRepository;
import com.api.zoobook.restapizoobook.repositores.ProdutoRepository;
import com.api.zoobook.restapizoobook.security.UserSS;
import com.api.zoobook.restapizoobook.services.exceptions.AuthorizationException;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;
import com.api.zoobook.restapizoobook.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ImageService imageService;

    @Value("${img.prefix.client.profile}")
    private String prefix;

    @Value("${img.profile.size}")
    private Integer size;

    public Produto find(Integer id) {
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
    }

    public Produto insert(Produto obj) {
        obj.setId(null);
        obj.setName(null);
        obj.setPrice(null);
        obj = repo.save(obj);
        return obj;
    }

    public Produto update(Produto obj) {
        Produto newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há relacionamento com outras entidades.");
        }
    }

    public Produto fromDTO(ProdutoDTO objDto) {
        return new Produto(objDto.getId(), objDto.getName(), objDto.getPrice());
    }

    public List<Produto> findAll() {
        return repo.findAll();
    }

    private void updateData(Produto newObj, Produto obj) {
        newObj.setName(obj.getName());
        newObj.setPrice(obj.getPrice());
        newObj.setImageUrl(obj.getImageUrl());
    }

    public URI uploadProfilePicture(MultipartFile multipartFile) {
        UserSS user = UserService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }

        BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
        jpgImage = imageService.cropSquare(jpgImage);
        jpgImage = imageService.resize(jpgImage, size);

        String fileName = prefix + user.getId() + ".jpg";

        URI uri = s3Service.uploadFile(multipartFile);

        return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");

    }
}