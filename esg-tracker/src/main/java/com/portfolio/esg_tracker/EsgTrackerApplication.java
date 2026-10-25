package com.portfolio.esg_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EsgTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsgTrackerApplication.class, args);
	}

}
