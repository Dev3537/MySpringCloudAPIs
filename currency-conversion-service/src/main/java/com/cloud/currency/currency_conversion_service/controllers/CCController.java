package com.cloud.currency.currency_conversion_service.controllers;

import com.cloud.currency.currency_conversion_service.payload.CurrencyConversion;
import com.cloud.currency.currency_conversion_service.proxies.CurrencyExchangeProxy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;

@Slf4j
@RestController
public class CCController {

	@Autowired
	private RestClient restClient;

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@Retry(name = "currencyConversion")
	@CircuitBreaker(name = "currencyConversion", fallbackMethod = "defaultFallBackMethod")
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/currency/{quantity}")
	public ResponseEntity<CurrencyConversion> getCurrencyConversion (@PathVariable String from,
	                                                                 @PathVariable String to,
	                                                                 @PathVariable BigDecimal quantity) {

		log.info("Inside getCurrencyConversion() method");
		//		String url = String.format("http://localhost:8000/currency-exchange/from/%s/to/%s", from, to);
		//		CurrencyConversion currencyConversion = restClient.get().uri(url).retrieve().body(CurrencyConversion
		//		.class);

		CurrencyConversion currencyConversion = currencyExchangeProxy.getCurrencyExchangeRate(from, to);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setEnvironment(
			"conversion-service:" + environment.getProperty("local.server.port") + " exchange-service:" +
				currencyConversion.getEnvironment());
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));


		return new ResponseEntity<CurrencyConversion>(currencyConversion, HttpStatus.OK);
	}

	public ResponseEntity<String> defaultFallBackMethod (String from, String to, BigDecimal quantity, Throwable e) {

		String response = "The following exception is thrown " + e.getMessage();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
}
