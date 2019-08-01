package com.sakshi.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiply;
	private BigDecimal quantity;
	private BigDecimal calculativeAmount;
	private int port;
	
	public CurrencyConversionBean() {
		
	}
	
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiply, BigDecimal quantity,
			BigDecimal calculativeAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiply = conversionMultiply;
		this.quantity = quantity;
		this.calculativeAmount = calculativeAmount;
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiply() {
		return conversionMultiply;
	}
	public void setConversionMultiply(BigDecimal conversionMultiply) {
		this.conversionMultiply = conversionMultiply;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getCalculativeAmount() {
		return calculativeAmount;
	}
	public void setCalculativeAmount(BigDecimal calculativeAmount) {
		this.calculativeAmount = calculativeAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	

}
