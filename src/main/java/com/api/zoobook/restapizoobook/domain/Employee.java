package com.api.zoobook.restapizoobook.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.Id;


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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Float getCommission() {
		return commission;
	}

	public void setCommission(Float commission) {
		this.commission = commission;
	}
}

