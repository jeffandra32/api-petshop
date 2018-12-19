package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfilePet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilePetRepository extends JpaRepository<ProfilePet, Integer> {


}
