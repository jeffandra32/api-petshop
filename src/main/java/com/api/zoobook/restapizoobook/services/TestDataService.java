package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Employee;
import com.api.zoobook.restapizoobook.repositores.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestDataService {

    private final EmployeeRepository employeeRepository;

    public TestDataService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    @Transactional
    public void createTestEmployeeData(){
        employeeRepository.saveAll(getTestEmployeeData());
    }

    public List<Employee> getTestEmployeeData(){
        final String[] employeeNames = {"David Smith", "Mike Jones", "John Jackson", "Pierre Williams", "Bob Roberts"};

        final List<Employee> employees = new ArrayList<>(employeeNames.length);

        int employeeNumber = 100;
        for(String name : employeeNames){
            employees.add(Employee.builder()
                    .empNo(employeeNumber)
                    .commission((float)employeeNumber / 75f)
                    .salary(employeeNumber * 888)
                    .name(name)
                    .build());

            employeeNumber++;
        }

        return employees;
    }
}