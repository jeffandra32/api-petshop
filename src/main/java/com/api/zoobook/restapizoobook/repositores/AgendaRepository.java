package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {


}
