package com.gfa.foxbook.foxbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FoxbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoxbookApplication.class, args);
	}

}
