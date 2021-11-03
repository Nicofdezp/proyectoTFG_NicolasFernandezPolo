package com.example.backend_gestionReservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BackendGestionReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendGestionReservasApplication.class, args);
	}

}
