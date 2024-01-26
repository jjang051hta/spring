package com.jjang051.outstargram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OutstargramApplication {
	public static void main(String[] args) {
		SpringApplication.run(OutstargramApplication.class, args);
	}

}
