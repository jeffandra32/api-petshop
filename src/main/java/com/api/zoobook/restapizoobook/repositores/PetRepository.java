package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {


}
