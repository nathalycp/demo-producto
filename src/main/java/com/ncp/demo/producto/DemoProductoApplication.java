package com.ncp.demo.producto;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.Nonnull;

@SpringBootApplication
public class DemoProductoApplication {
	
	@Nonnull
	private LocalDate date;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoProductoApplication.class, args);
	}

}
