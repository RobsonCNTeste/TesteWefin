package com.wefin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class TesteWefinGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteWefinGatewayApplication.class, args);
	}


	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder
				.routes()
					.route( r -> r.path("/pessoas/**").uri("lb://mspessoa") )
				.build();
	}
}
