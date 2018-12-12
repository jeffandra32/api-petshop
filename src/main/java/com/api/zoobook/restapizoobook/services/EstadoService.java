package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Estado;
import com.api.zoobook.restapizoobook.repositores.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;

    public List<Estado> findAll() {
        return repo.findAllByOrderByNome();
    }
}
