package com.swarna.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("employee")
public class Employee {
	
    @Id
    @Column("empID")
    private Integer empID;
    private String empName;
    private String dept;
    	
}
