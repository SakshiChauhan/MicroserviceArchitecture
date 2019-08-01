package com.sakshi.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sakshi.microservices.limitsservice.bean.LimitConfiguartion;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguartion getLimitConfiguartion() {
		return new LimitConfiguartion(configuration.getMaximum(), configuration.getMinimum());
	}
	
	@GetMapping("/fault-tolerance-limits")
	@HystrixCommand(fallbackMethod = "getFallBackLimits")
	public LimitConfiguartion getFaultLimitConfiguartion() {
		throw new RuntimeException("Service Not available");
	}
	
	public LimitConfiguartion getFallBackLimits() {
		return new LimitConfiguartion(10, 1);
	}

}
