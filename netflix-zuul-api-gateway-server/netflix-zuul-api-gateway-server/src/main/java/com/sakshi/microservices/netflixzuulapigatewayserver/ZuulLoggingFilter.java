package com.sakshi.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		//Should this filter if execute or not(Can implement some logic as well)
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//Implement filter logic here: What should happen
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request -> {} request uri -> {} ", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		//when filter should get executed: pre(before request execution),post(after),error(only when error comes)
		return "pre";
	}

	@Override
	public int filterOrder() {
		//If multiple filters are implemented, it is used to set priority of filters
		return 1;
	}

}
