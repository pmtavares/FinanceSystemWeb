package com.finance.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//localhost:8080/Financial/rest
@ApplicationPath("rest")
public class FinanceResourceConfig extends ResourceConfig {
	
	public FinanceResourceConfig()
	{
		packages("com.finance.service");
	}

}
