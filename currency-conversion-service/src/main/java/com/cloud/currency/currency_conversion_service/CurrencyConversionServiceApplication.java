package com.cloud.currency.currency_conversion_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceApplication {

	public static void main (String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

	@Bean
	public RestClient restClient () {
		return RestClient.builder().build();
	}

}
