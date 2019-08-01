package com.sakshi.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean responseBody = responseEntity.getBody();
		logger.info("Currency Conversion Controller..............................");
		return new CurrencyConversionBean(responseBody.getId(), from, to, responseBody.getConversionMultiply(),
				quantity, quantity.multiply(responseBody.getConversionMultiply()), responseBody.getPort());
	}
	
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyWithFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
	
		CurrencyConversionBean responseBody = proxy.getExchange(from, to);
		logger.info("Currency Conversion Feign Controller..............................");
		return new CurrencyConversionBean(responseBody.getId(), from, to, responseBody.getConversionMultiply(),
				quantity, quantity.multiply(responseBody.getConversionMultiply()), responseBody.getPort());
	}

}
