package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
