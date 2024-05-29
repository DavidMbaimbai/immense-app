package com.davymbaimbai.ecommerce;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/immense", "tino", "root").load();
		flyway.repair();
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
