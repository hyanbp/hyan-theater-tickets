package me.umov.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import me.umov.request.TheaterRequest;
import me.umov.response.TheaterResponse;

@Path("/services")
public interface TheaterService extends BaseService{
	
	@GET
	@Path("/buy-ticket")
	public TheaterResponse buyTicket(TheaterRequest request);

}
