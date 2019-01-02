package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.Usuario;
import com.api.zoobook.restapizoobook.domain.servico.Servico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    @Transactional(readOnly=true)
    Page<Servico> findByUsuario(Usuario usuario, PageRequest pageRequest);
}
