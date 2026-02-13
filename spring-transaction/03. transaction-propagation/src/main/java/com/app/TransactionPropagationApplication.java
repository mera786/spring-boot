package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackages = "com.app.NESTED")
// ✅ Only scan REQUIRES_NEW repositories
@EnableJpaRepositories(basePackages = "com.app.NESTED.repository")

// ✅ Only scan REQUIRES_NEW entities
@EntityScan(basePackages = "com.app.NESTED.entity")
public class TransactionPropagationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionPropagationApplication.class, args);
	}

}
