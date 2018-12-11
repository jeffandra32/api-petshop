package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {


}
