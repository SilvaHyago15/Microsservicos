package com.meuexemplo.controleprodutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ControleProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleProdutosApplication.class, args);
	}

}
