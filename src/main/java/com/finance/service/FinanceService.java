package com.finance.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("finance")
public class FinanceService {
	
	@GET
	public String hello()
	{
		return "Hello Pedro - Finance";
	}

}
