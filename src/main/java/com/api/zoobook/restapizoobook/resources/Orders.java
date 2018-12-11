package com.api.zoobook.restapizoobook.resources;


import com.api.zoobook.restapizoobook.domain.Pedido;
import com.api.zoobook.restapizoobook.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "v1/orders")
public class Orders {

    @Autowired
    private PedidoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> find(@PathVariable Integer id){
        Pedido obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
