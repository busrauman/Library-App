package com.library.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableEntityLinks;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.library.app.repository"})
@EntityScan(basePackages= {"com.library.app.model"})
@ComponentScan(basePackages= {"com.library.app.controller","com.library.app.service"})
public class LibraryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAppApplication.class, args);
	}
}
