package com.cloud.currency.currency_exchange_service.Controllers;

import com.cloud.currency.currency_exchange_service.Payload.CurrencyExchange;
import com.cloud.currency.currency_exchange_service.Payload.repositories.CurrencyExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
public class CEController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<CurrencyExchange> getCurrencyExchangeRate (@PathVariable String from,
	                                                                 @PathVariable String to) {
		log.info("Called Currency Exchange for currency from {} to {}", from, to);
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		if (currencyExchange == null)
			throw new RuntimeException("No currency data found for the values supplied");
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
	}

}

