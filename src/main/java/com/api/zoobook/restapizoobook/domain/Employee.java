package com.api.zoobook.restapizoobook.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Data
@Builder
public class Employee {

    @Id
    private Integer empNo;

    private String name;

    private Integer salary;

    private Float commission;

    @Tolerate
    public Employee(){}
}

