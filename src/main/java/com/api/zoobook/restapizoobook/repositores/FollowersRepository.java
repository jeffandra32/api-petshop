package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.socialNetwork.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowersRepository extends JpaRepository<Followers, Integer> {
    
}
