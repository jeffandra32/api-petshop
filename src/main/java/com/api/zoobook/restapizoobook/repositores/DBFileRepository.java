package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {


}
