package me.umov.service;

import org.springframework.stereotype.Service;

import me.umov.model.Person;
import me.umov.model.Person.PersonType;
import me.umov.model.SaleEnum;
import me.umov.request.TheaterRequest;
import me.umov.response.TheaterResponse;

@Service
public class TheaterServiceImpl implements TheaterService {

	public Double calculateDiscount(PersonType personType, Double valueTickets, Integer dayWeekCode) {
		Double percent = 0.0;
		switch (dayWeekCode) {
		case 2:
			// segunda
			return setDiscountForMonday(valueTickets, percent);
		case 3:
			// terca
			return setDiscountForTuesday(personType, valueTickets, percent);
		case 4:
			// quarta
			return setDiscountForWednesday(personType, valueTickets, percent);
		case 5:
			// quinta
			return setDiscountForThursday(personType, valueTickets, percent);
		case 6:
			// sexta
			return setDiscountForFriday(personType, valueTickets, percent);
		case 1:
		case 7:
		case 8:
			// sabado e domingo
			return setDiscountForWeekend(personType, valueTickets, percent);
		default:
			return valueTickets;
		}
	}

	/**
	 * Final de semana. Sabado/Domingo - 5% Idosos
	 * 
	 * @param person
	 * @param valueTickets
	 * @param percent
	 * @return
	 */
	private static Double setDiscountForWeekend(PersonType personType, Double valueTickets, Double percent) {
		if (personType.equals(PersonType.SENIOR)) {
			return discountDay(valueTickets, SaleEnum.ELEVEN.getValue());
		}
		return valueTickets;
	}

	/**
	 * Sexta-Feira - 11% crianças
	 * 
	 * @param person
	 * @param valueTickets
	 * @param percent
	 * @return
	 */
	private static Double setDiscountForFriday(PersonType personType, Double valueTickets, Double percent) {
		if (personType.equals(PersonType.CHILD)) {
			return discountDay(valueTickets, SaleEnum.ELEVEN.getValue());
		}
		return valueTickets;
	}

	/**
	 * Quinta-feira - 30% idosos e estudantes
	 * 
	 * @param person
	 * @param valueTickets
	 * @param percent
	 * @return
	 */
	private static Double setDiscountForThursday(PersonType personType, Double valueTickets, Double percent) {
		if (personType.equals(PersonType.SENIOR) || personType.equals(PersonType.STUDENT)) {
			return discountDay(valueTickets, SaleEnum.THIRTY.getValue());
		}
		return valueTickets;
	}

	/**
	 * 
	 * @param person
	 * @param valueTickets
	 * @param percent
	 * @return Quarta-Feira: 40% idosos 30% crianças 50% estudantes
	 */
	private static Double setDiscountForWednesday(PersonType personType, Double valueTickets, Double percent) {
		if (personType.equals(PersonType.CHILD)) {
			return discountDay(valueTickets, SaleEnum.THIRTY.getValue());
		} else if (personType.equals(PersonType.SENIOR)) {
			return discountDay(valueTickets, SaleEnum.FORTY.getValue());
		} else if (personType.equals(PersonType.STUDENT)) {
			return discountDay(valueTickets, SaleEnum.FIFTY.getValue());
		}
		return valueTickets;
	}

	public static double discountDay(Double valueTickets, Double percent) {
		return valueTickets - (percent * valueTickets);
	}

	/**
	 * @param valueTickets
	 * @param percent
	 * @return Segunda-Feira: 10% para todos(crianças, idosos, estudantes
	 */
	private static Double setDiscountForMonday(Double valueTickets, Double percent) {
		return discountDay(valueTickets, SaleEnum.TEN.getValue());
	}

	/**
	 * @param person
	 * @param valueTickets
	 * @param percent
	 * @return Terça-Feira: 15% idosos e crianças; 5% estudantes;
	 */
	private static Double setDiscountForTuesday(PersonType personType, Double valueTickets, Double percent) {
		if (personType.equals(PersonType.SENIOR) || personType.equals(PersonType.CHILD)) {
			return discountDay(valueTickets, SaleEnum.FIFTEEN.getValue());
		} else if (personType.equals(PersonType.STUDENT)) {
			return discountDay(valueTickets, SaleEnum.FIFTY.getValue());
		}
		return valueTickets;
	}

	public static Double discountMaxForStudent(Double valueTickets) {
		return discountDay(valueTickets, SaleEnum.THIRTY_FIVE.getValue());
	}

	public TheaterResponse buyTicket(TheaterRequest request) {
		if (request != null) {
			Person person = translateRequest(request);
			Double valueTickets = getPriceTickets(person.getType());
			valueTickets = calculateDiscount(person.getType(), valueTickets, request.getWeekDayCode() != null ? request.getWeekDayCode() : 7);
			if (person.getStudentCard()) {
				valueTickets = discountMaxForStudent(valueTickets);
				return new TheaterResponse(valueTickets);
			} else {
				return new TheaterResponse(valueTickets);
			}
		}
		return null;
	}

	private Person translateRequest(TheaterRequest request) {
		if (request != null) {
			Person person = new Person();
			person.setStudentCard(request.getStudentCard());
			person.setType(PersonType.forCode(request.getTypePerson()));
			return person;
		}
		return null;
	}

	public Double getPriceTickets(PersonType personType) {
		switch (personType) {
		case CHILD:
			return 5.5;
		case STUDENT:
			return 8.0;
		case SENIOR:
			return 6.0;
		default:
			return 10.0;
		}

	}
}
