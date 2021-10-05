package com.algaworks.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class AlgacrmApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgacrmApiApplication.class, args);
	}

}
