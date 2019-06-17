package com.springconference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.springconference"})
public class SpringConferenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConferenceApplication.class, args);
	}

}
