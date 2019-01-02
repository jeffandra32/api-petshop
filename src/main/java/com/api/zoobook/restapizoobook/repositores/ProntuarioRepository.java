package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.pet.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Integer> {

}
