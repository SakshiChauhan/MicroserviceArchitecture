package com.sakshi.microservices.limitsservice.bean;

public class LimitConfiguartion {
	
	private int minimum;
	
	private int maximum;
	
	public LimitConfiguartion() {
		super();
	}

	public LimitConfiguartion(int maximum, int minimum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}
	
}
