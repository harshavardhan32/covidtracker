package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CaronavirusTrackerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(CaronavirusTrackerApplication.class, args);
		
		
		
	}

}
