package com.sakshi.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchange(@PathVariable String from, @PathVariable String to) {
		ExchangeValue value = exchangeValueRepository.findByFromAndTo(from, to);	
		value.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("Currency Exchange Controller................................");
		return value;
	}

}
