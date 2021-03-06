package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.servico.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


}
