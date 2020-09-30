package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SpringBootRestDataJpaSwaggerProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestDataJpaSwaggerProviderApplication.class, args);
	}

}
