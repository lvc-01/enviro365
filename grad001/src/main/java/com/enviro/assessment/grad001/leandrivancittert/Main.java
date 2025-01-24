package com.enviro.assessment.grad001.leandrivancittert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.enviro.assessment.grad001.leandrivancittert.repository")
@EntityScan(basePackages = "com.enviro.assessment.grad001.leandrivancittert.models")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
