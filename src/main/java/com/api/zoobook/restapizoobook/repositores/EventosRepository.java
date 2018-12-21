package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.agenda.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Integer> {

}
