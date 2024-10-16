package com.cloud.currency.currency_conversion_service.proxies;

import com.cloud.currency.currency_conversion_service.payload.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {


	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getCurrencyExchangeRate (@PathVariable String from, @PathVariable String to);

}
