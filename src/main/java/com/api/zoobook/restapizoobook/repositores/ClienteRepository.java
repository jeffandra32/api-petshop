package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Usuario, Integer> {
    @Transactional(readOnly=true)
    Usuario findByEmail(String email);

}
