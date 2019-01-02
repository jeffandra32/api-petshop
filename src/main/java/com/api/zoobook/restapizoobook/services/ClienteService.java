package com.api.zoobook.restapizoobook.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.api.zoobook.restapizoobook.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.api.zoobook.restapizoobook.domain.Cidade;
import com.api.zoobook.restapizoobook.domain.Endereco;
import com.api.zoobook.restapizoobook.domain.enums.Perfil;
import com.api.zoobook.restapizoobook.domain.enums.TipoUsuario;
import com.api.zoobook.restapizoobook.dto.UsuarioDTO;
import com.api.zoobook.restapizoobook.dto.ClienteNewDTO;
import com.api.zoobook.restapizoobook.repositores.ClienteRepository;
import com.api.zoobook.restapizoobook.repositores.EnderecoRepository;
import com.api.zoobook.restapizoobook.security.UserSS;
import com.api.zoobook.restapizoobook.services.exceptions.AuthorizationException;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;
import com.api.zoobook.restapizoobook.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ImageService imageService;

    @Value("${img.prefix.client.profile}")
    private String prefix;

    @Value("${img.profile.size}")
    private Integer size;

    public Usuario find(Integer id) {

        UserSS user = UserService.authenticated();
        if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException("Acesso negado");
        }

        Optional<Usuario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

    @Transactional
    public Usuario insert(Usuario obj) {
        obj.setId(null);
        obj = repo.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    @Transactional
    public Usuario insertLogin(Usuario obj) {
        obj = repo.save(obj);
        return obj;
    }


    public Usuario update(Usuario obj) {
        Usuario newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
        }
    }

    public List<Usuario> findAll() {
        return repo.findAll();
    }

    public Usuario findByEmail(String email) {
        UserSS user = UserService.authenticated();
        if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
            throw new AuthorizationException("Acesso negado");
        }

        if (user == null || !user.hasRole(Perfil.FORNECEDOR) && !email.equals(user.getUsername())) {
            throw new AuthorizationException("Acesso negado");
        }

        if (user == null || user.hasRole(Perfil.SUSPENSO) && !email.equals(user.getUsername())) {
            throw new AuthorizationException("Acesso negado");
        }

        Usuario obj = repo.findByEmail(email);
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Usuario.class.getName());
        }
        return obj;
    }

    public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Usuario fromDTO(UsuarioDTO objDto) {
        return new Usuario(objDto.getId(), objDto.getName(), objDto.getEmail(),null , null,null, null, null);
    }

    public Usuario fromDTO(ClienteNewDTO objDto) {
        Usuario cli = new Usuario(null, objDto.getName(), objDto.getEmail(), objDto.getCpfOuCnpj(), objDto.getBirthDate(), objDto.getCreateAt() ,TipoUsuario.toEnum(objDto.getType()), pe.encode(objDto.getPassword()));
        Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
        Endereco end = new Endereco(null, objDto.getAddress(), objDto.getNumber(), objDto.getComplement(), objDto.getNeighborhood(), objDto.getCep(), cli, cid);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDto.getFone1());
        if (objDto.getFone2()!=null) {
            cli.getTelefones().add(objDto.getFone2());
        }
        if (objDto.getFone3()!=null) {
            cli.getTelefones().add(objDto.getFone3());
        }
        return cli;
    }

    private void updateData(Usuario newObj, Usuario obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
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