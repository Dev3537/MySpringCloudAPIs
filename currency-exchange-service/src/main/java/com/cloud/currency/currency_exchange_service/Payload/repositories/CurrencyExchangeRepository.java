package com.cloud.currency.currency_exchange_service.Payload.repositories;

import com.cloud.currency.currency_exchange_service.Payload.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	@Query(nativeQuery = true, value = "select * from currency_exchange where currency_from=:from and currency_to=:to")
	CurrencyExchange findByFromAndTo (String from, String to);
}
