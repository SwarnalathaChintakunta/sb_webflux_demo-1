package com.swarna.app.controller;

import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


public class FunctionalStyleHelloController {

	
	RouterFunction<ServerResponse> route =
		    RouterFunctions.route(
		        RequestPredicates.GET("/hello"),
		        request -> ServerResponse.ok().bodyValue("Hello WebFlux")
		    );

}
