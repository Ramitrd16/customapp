package com.microservices.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
//        return routeLocatorBuilder.routes().build();
//    }

//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
//        return routeLocatorBuilder.routes()
//                .route(p -> p.path("/get")
//                        .filters(f -> f.addRequestHeader("Har Har Mahadev", "Namaskaram"))
//						.uri("http://httpbin.org:80")).build();
//    }

}
