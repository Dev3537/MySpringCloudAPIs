package com.cloud.currency.currency_exchange_service;

import com.cloud.currency.currency_exchange_service.Payload.CurrencyExchange;
import com.cloud.currency.currency_exchange_service.Payload.repositories.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main (String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;

	@Bean
	public CommandLineRunner initData () {
		return args -> {

			List<CurrencyExchange> currencyExchangeList = new ArrayList<>();
			currencyExchangeList.add(new CurrencyExchange("USD", "INR", BigDecimal.valueOf(80)));
			currencyExchangeList.add(new CurrencyExchange("EUR", "INR", BigDecimal.valueOf(100)));
			currencyExchangeList.add(new CurrencyExchange("AUD", "INR", BigDecimal.valueOf(55)));
			currencyExchangeRepository.saveAll(currencyExchangeList);

		};
	}

}
