package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {



}
