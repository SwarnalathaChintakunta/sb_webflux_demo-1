package com.swarna.app.handler;

import org.springframework.stereotype.Component;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.created;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.swarna.app.model.Employee;
import com.swarna.app.repository.EmployeeRepository;
import com.swarna.app.repository.EmployeeRepositoryInterf;

import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class EmployeeHandler {

    private final EmployeeRepositoryInterf repository;

    public EmployeeHandler(EmployeeRepositoryInterf repository) {
        this.repository = repository;
    }

    // GET /employees
//    public Mono<ServerResponse> getAllEmployees(ServerRequest request) {
//        return ok().body(repository.findAll(), Employee.class);
//    }
//
//    // GET /employees/{id}
//    public Mono<ServerResponse> getEmployeeById(ServerRequest request) {
//        Integer id = Integer.valueOf(request.pathVariable("id"));
//
//        return repository.findById(id)
//                .flatMap(emp -> ok().bodyValue(emp))
//                .switchIfEmpty(ServerResponse.notFound().build());
//    }
    
    
    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ok().body(repository.findAll(), Employee.class);
    }

    // GET /employees/{id}
    public Mono<ServerResponse> getById(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));

        return repository.findById(id)
                .flatMap(emp -> ok().bodyValue(emp))
                .switchIfEmpty(notFound().build());
    }

    // POST /employees
    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(Employee.class)
                .flatMap(repository::save)
                .flatMap(saved -> created(request.uri())
                        .bodyValue(saved));
    }
    
    @Transactional
    public Mono<Employee> saveEmployee(Employee emp) {
        return repository.save(emp);
    }

}
