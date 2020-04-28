package com.startup.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplatePocApplication {

	private static final Logger log = LoggerFactory.getLogger(RestTemplatePocApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestTemplatePocApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String response = restTemplate.getForObject("https://www.google.com", String.class);
			log.info(response);
		};
	}
}
