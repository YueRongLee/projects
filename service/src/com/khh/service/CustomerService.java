package com.khh.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.khh.domain.Customer;

@Path("/customerservice")
public class CustomerService {
	
	@Path("/cust")
	@GET
	@Produces("application/json")
	public String customer(){
		Customer customer = new Customer("0001","Jason","巨匠高雄認證中心","高雄市新興區");
		Gson gson = new Gson();
		String jsonString=gson.toJson(customer);
		return jsonString;
	}
}
