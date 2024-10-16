package com.cloud.currency.currency_exchange_service.Payload;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="currency_from")
	private String from;

	@Column(name="currency_to")
	private String to;

	private BigDecimal conversionMultiple;

	private String environment;

	public CurrencyExchange (String from, String to, BigDecimal conversionMultiple) {
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnvironment () {
		return environment;
	}

	public void setEnvironment (String environment) {
		this.environment = environment;
	}

	public String getFrom () {
		return from;
	}

	public Long getId () {
		return id;
	}

	public String getTo () {
		return to;
	}

	public BigDecimal getConversionMultiple () {
		return conversionMultiple;
	}

	public void setFrom (String from) {
		this.from = from;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public void setTo (String to) {
		this.to = to;
	}

	public void setConversionMultiple (BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public CurrencyExchange (String from, Long id, String to, BigDecimal conversionMultiple) {
		this.from = from;
		this.id = id;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public CurrencyExchange () {
	}
}
