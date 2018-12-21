package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Transactional(readOnly=true)
    Cliente findByEmail(String email);

}
