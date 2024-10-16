package com.cloud.currency.currency_conversion_service.payload;

import java.math.BigDecimal;

public class CurrencyConversion {
	private Long id;

	private String from;

	private String to;

	private BigDecimal conversionMultiple;

	private BigDecimal quantity;

	private BigDecimal totalCalculatedAmount;

	private String environment;

	public CurrencyConversion (String from, String to, BigDecimal conversionMultiple, BigDecimal quantity) {
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
	}

	public void setTotalCalculatedAmount (BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public void setQuantity (BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount () {
		return totalCalculatedAmount;
	}

	public BigDecimal getQuantity () {
		return quantity;
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

	public CurrencyConversion (String from, Long id, String to, BigDecimal conversionMultiple) {
		this.from = from;
		this.id = id;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public CurrencyConversion () {
	}
}

