package com.wefin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableEurekaClient
public class TesteWefinPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteWefinPessoaApplication.class, args);
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
      return new OpenAPI()
              .info(new Info().title("Teste Wefin API")
              .description("Api para testar conhecimentos do Robson")
              .version("v0.0.1")
              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
              .externalDocs(new ExternalDocumentation());
  }
}
