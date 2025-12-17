package com.swarna.app.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.swarna.app.handler.EmployeeHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class EmployeeRouter {

    @Bean
    public RouterFunction<ServerResponse> employeeRoutes(EmployeeHandler handler) {

//        return route(GET("/employees"), handler::getAllEmployees)
//                .andRoute(GET("/employees/{id}"), handler::getEmployeeById);
    	
    	
    	 return route(GET("/employees"), handler::getAll)
                 .andRoute(GET("/employees/{id}"), handler::getById)
                 .andRoute(POST("/employees"), handler::save);
    }
}
