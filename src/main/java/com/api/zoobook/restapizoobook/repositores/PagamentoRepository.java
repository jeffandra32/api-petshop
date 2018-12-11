package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {


}
