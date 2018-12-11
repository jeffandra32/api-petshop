package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}
