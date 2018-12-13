package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.PetCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetCategoriaRepository extends JpaRepository<PetCategoria, Integer> {


}
