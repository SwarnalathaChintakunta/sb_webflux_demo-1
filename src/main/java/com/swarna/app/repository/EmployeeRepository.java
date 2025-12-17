package com.swarna.app.repository;

import org.springframework.stereotype.Repository;

import com.swarna.app.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> employees = List.of(
        new Employee(1, "Reha", "IT"),
        new Employee(2, "Amit", "HR"),
        new Employee(3, "Sita", "Finance")
    );

    public Flux<Employee> findAll() {
        return Flux.fromIterable(employees);
    }

    public Mono<Employee> findById(Integer id) {
        return Flux.fromIterable(employees)
                   .filter(e -> e.getEmpID().equals(id))
                   .next();
    }

	
}
