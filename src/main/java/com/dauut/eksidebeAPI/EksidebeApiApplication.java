package com.dauut.eksidebeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EksidebeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EksidebeApiApplication.class, args);
	}

}
