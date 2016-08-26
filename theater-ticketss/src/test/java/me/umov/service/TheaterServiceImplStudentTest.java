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
public class TheaterServiceImplStudentTest extends TestCase {
	
	
	@InjectMocks TheaterServiceImpl theaterServiceImpl;
	

	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void testCalculateStudentInMonday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.MONDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.TEN.getValue());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateStudentInTuesday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.TUESDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.FIVE.getValue());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateStudentInWednesday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.WEDNESDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.FIFTY.getValue());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	
	@Test
	public void testCalculateStudentInThursday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.THURSDAY.getValue());
		
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));
		
		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.THIRTY.getValue());		
		
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	
	@Test
	public void testCalculateStudentInFriday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.FRIDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = theaterServiceImpl.calculateDiscount(PersonType.forCode(request.getTypePerson()), ticket, request.getWeekDayCode());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateStudentWeekend() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.SATURDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = theaterServiceImpl.calculateDiscount(PersonType.forCode(request.getTypePerson()), ticket, request.getWeekDayCode());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	
	@Test
	public void testCalculateStudentHoliday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.FALSE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.HOLIDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = theaterServiceImpl.calculateDiscount(PersonType.forCode(request.getTypePerson()), ticket, request.getWeekDayCode());
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	
	//////TESTES APRESENTANDO A CARTEIRA DE ESTUDANTE
	
	@Test
	public void testCalculateStudentWithStudentCardMonday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.TRUE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.MONDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.TEN.getValue());
		ticketReal = TheaterServiceImpl.discountMaxForStudent(ticketReal);
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateStudentWithStudentCardTuesday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.TRUE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.TUESDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.FIVE.getValue());
		ticketReal = TheaterServiceImpl.discountMaxForStudent(ticketReal);
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateStudentWithStudentCardWednesday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.TRUE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.WEDNESDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.FIFTY.getValue());
		ticketReal = TheaterServiceImpl.discountMaxForStudent(ticketReal);
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateStudentWithStudentCardThursday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.TRUE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.THURSDAY.getValue());
		
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));
		
		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = ticket - (ticket * SaleEnum.THIRTY.getValue());		
		ticketReal = TheaterServiceImpl.discountMaxForStudent(ticketReal);
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateStudentWithStudentCardFriday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.TRUE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.FRIDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = theaterServiceImpl.calculateDiscount(PersonType.forCode(request.getTypePerson()), ticket, request.getWeekDayCode());
		ticketReal = TheaterServiceImpl.discountMaxForStudent(ticketReal);
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateStudentWithStudentCardWeekend() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.TRUE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.SATURDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = theaterServiceImpl.calculateDiscount(PersonType.forCode(request.getTypePerson()), ticket, request.getWeekDayCode());
		ticketReal = TheaterServiceImpl.discountMaxForStudent(ticketReal);
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}
	
	@Test
	public void testCalculateStudentWithStudentCardHoliday() {
		TheaterRequest request = new TheaterRequest();
		request.setStudentCard(Boolean.TRUE);
		request.setTypePerson(PersonType.STUDENT.getCode());
		request.setWeekDayCode(DayWeekEnum.HOLIDAY.getValue());
		Double ticket = theaterServiceImpl.getPriceTickets(PersonType.forCode(request.getTypePerson()));

		TheaterResponse response = theaterServiceImpl.buyTicket(request);
		Double ticketReal = theaterServiceImpl.calculateDiscount(PersonType.forCode(request.getTypePerson()), ticket, request.getWeekDayCode());
		ticketReal = TheaterServiceImpl.discountMaxForStudent(ticketReal);
		assertEquals(response.getValueTicket(), ticketReal, 0);
	}


}
