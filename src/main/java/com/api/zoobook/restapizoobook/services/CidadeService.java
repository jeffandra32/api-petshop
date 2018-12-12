package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Cidade;
import com.api.zoobook.restapizoobook.repositores.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repo;

    public List<Cidade> findByEstado(Integer estadoId) {
        return repo.findCidades(estadoId);
    }
}
