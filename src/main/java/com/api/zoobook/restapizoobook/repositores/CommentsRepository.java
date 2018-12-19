package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.socialNetwork.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {
    
}
