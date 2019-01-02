package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.*;
import com.api.zoobook.restapizoobook.domain.pet.Pet;
import com.api.zoobook.restapizoobook.dto.PetDTO;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.PetRepository;
import com.api.zoobook.restapizoobook.security.UserSS;
import com.api.zoobook.restapizoobook.services.exceptions.AuthorizationException;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository repo;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ImageService imageService;

    @Value("${img.prefix.client.profile}")
    private String prefix;

    @Value("${img.profile.size}")
    private Integer size;


    public Pet find(Integer id) {
        Optional<Pet> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pet.class.getName()));
    }

    public Pet insert(Pet obj) {
        obj.setId(null);
        obj.setBirthDate(new Date());
        obj.setAcceptRelationship(true);
        obj.setDonation(false);
        obj.setFiliation(null);
        obj.setName(null);
        obj.setBreed(null);
        obj.setAge(null);
        obj.setType(null);
        obj.setUsuario(clienteService.find(obj.getUsuario().getId()));
        obj = repo.save(obj);
        return obj;
    }

    public Pet update(Pet obj) {
        Pet newObj = find(obj.getId());
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

    public List<Pet> findAll() {
        return repo.findAll();
    }


    public Pet fromDTO(PetDTO objDto) {
        return new Pet(objDto.getId(), objDto.getName(), objDto.getBreed(),
                objDto.getAge(), objDto.getBirthDate(),
                objDto.getWeight(), objDto.getFiliation(), null, objDto.isAcceptRelationship(),
                objDto.isDonation(), null);
    }


    public Page<Pet> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        UserSS user = UserService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Usuario usuario =  clienteService.find(user.getId());
        return repo.findByUsuario(usuario, pageRequest);
    }

    private void updateData(Pet newObj, Pet obj) {
        newObj.setName(obj.getName());
        newObj.setBreed(obj.getBreed());
        newObj.setAge(obj.getAge());
        newObj.setBirthDate(obj.getBirthDate());
        newObj.setWeight(obj.getWeight());
        newObj.setFiliation(obj.getFiliation());
        newObj.setAcceptRelationship(obj.isAcceptRelationship());
        newObj.setDonation(obj.isDonation());
        newObj.setImageUrl(obj.getImageUrl());
        newObj.setType(obj.getType());
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
