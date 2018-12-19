package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.socialNetwork.PostsUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostUsuarioRepository extends JpaRepository<PostsUsuario, Integer> {

}
