package me.umov.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.TestCase;
import me.umov.model.DayWeekEnum;
import me.umov.model.Person.PersonType;
import me.umov.model.SaleEnum;
import me.umov.request.TheaterRequest;
import me.umov.response.TheaterResponse;

@RunWith(MockitoJUnitRunner.class)
public class TheaterServiceImplChildTest extends TestCase {
	
	@InjectMocks TheaterServiceImpl theaterServiceImpl;

	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}
	
	
	@Test
	public void testCalculateChildInMonday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.CHILD.getCode());
		request.setWeekDayCode(DayWeekEnum.MONDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.TEN.getValue());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateChildInTuesday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.CHILD.getCode());
		request.setWeekDayCode(DayWeekEnum.TUESDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.FIFTEEN.getValue());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateChildInWednesday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.CHILD.getCode());
		request.setWeekDayCode(DayWeekEnum.WEDNESDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.THIRTY.getValue());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	
	@Test
	public void testCalculateChildInThursday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.CHILD.getCode());
		request.setWeekDayCode(DayWeekEnum.THURSDAY.getValue());
		
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));
		
		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketFinal = theaterServiceImpl.calculateDiscount(PersonType.forCode(request.getTypePerson()), ticket, request.getWeekDayCode());
		
		
		assertEquals(response.getValueTicket(), ticketFinal, 0);
	}
	
	
	@Test
	public void testCalculateChildInFriday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.CHILD.getCode());
		request.setWeekDayCode(DayWeekEnum.FRIDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.ELEVEN.getValue());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateChildWeekend() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.CHILD.getCode());
		request.setWeekDayCode(DayWeekEnum.SATURDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = theaterServiceImpl.calculateDiscount(PersonType.forCode(request.getTypePerson()), ticket, request.getWeekDayCode());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	
	@Test
	public void testCalculateChildHoliday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.CHILD.getCode());
		request.setWeekDayCode(DayWeekEnum.HOLIDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = theaterServiceImpl.calculateDiscount(PersonType.forCode(request.getTypePerson()), ticket, request.getWeekDayCode());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	


}
