package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Pedido;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscar(Integer id){
        Optional<Pedido> obj = pedidoRepository.findById(id);
            if(obj == null){
                throw new ObjectNotFoundException("Objeto não encontrado ID: " + id
                        + " , Tipo: " + Pedido.class.getName());
            }
        return obj.orElse(null);
    }
}
