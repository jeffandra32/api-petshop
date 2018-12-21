package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.Cliente;
import com.api.zoobook.restapizoobook.domain.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Transactional(readOnly=true)
    Page<Pet> findByCliente(Cliente cliente, PageRequest pageRequest);
}
