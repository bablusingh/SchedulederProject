package com.app.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class SchedulederProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulederProjectApplication.class, args);
	}
	
	@Bean
	public RestTemplate resttamplate()
	{
		return new RestTemplate();
	}

}
