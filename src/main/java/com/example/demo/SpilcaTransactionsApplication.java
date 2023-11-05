package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"controllers","repositories","service"})
public class SpilcaTransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpilcaTransactionsApplication.class, args);
	}

}
