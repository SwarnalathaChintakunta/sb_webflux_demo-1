package com.swarna.app.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.swarna.app.model.Employee;

import reactor.core.publisher.Flux;

public interface EmployeeRepositoryInterf extends ReactiveCrudRepository<Employee, Integer> {
 
	Flux<Employee> findByDept(String dept);
}
