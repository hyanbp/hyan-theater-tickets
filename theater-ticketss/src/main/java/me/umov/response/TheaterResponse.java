package me.umov.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("getBuyTicket")
@JsonInclude(Include.NON_NULL)
public class TheaterResponse {
	
	private Double ticketValue;
	
	
	public TheaterResponse(Double ticketValue) {
		this.ticketValue = ticketValue;
	}

	public Double getValueTicket() {
		return ticketValue;
	}

	public void setValueTicket(Double ticketValue) {
		this.ticketValue = ticketValue;
	}
	

}
