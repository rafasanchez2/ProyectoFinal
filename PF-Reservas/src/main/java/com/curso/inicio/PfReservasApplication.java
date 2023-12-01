package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * Clase principal que inicia nuestra aplicación. 
 * {@link EntityScan} identifica el paquete base para escanear entidades.
 * {@link EnableJpaRepositories} identifica el paquete base para escanear repositorios JPA.
 * {@link SpringBootApplication} identifica los componentes en la aplicación. Se
 * escanean para encontrar controladores y servicios respectivamente.
 */
@EntityScan(basePackages = "com.curso.modelo")
@EnableJpaRepositories(basePackages = "com.curso.dao")
@SpringBootApplication(scanBasePackages = { "com.curso.controller", "com.curso.service" })
public class PfReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfReservasApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}