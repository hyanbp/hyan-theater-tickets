package me.umov.request;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("theaterRequest")
public class TheaterRequest {
	
	private Boolean studentCard;
	private Integer typePerson;
	private Integer weekDayCode;
	
	
	public Boolean getStudentCard() {
		return studentCard;
	}
	public void setStudentCard(Boolean studentCard) {
		this.studentCard = studentCard;
	}
	public Integer getTypePerson() {
		return typePerson;
	}
	public void setTypePerson(Integer studentCard) {
		this.typePerson = studentCard;
	}
	
	public Integer getWeekDayCode() {
		return weekDayCode;
	}
	public void setWeekDayCode(Integer weekDayCode) {
		this.weekDayCode = weekDayCode;
	}
	
	@Override
	public String toString() {
		return "TheaterRequest [" +
				"studentCard=" + studentCard +
				"weekDayCode=" + weekDayCode +
				"typePerson=" + typePerson + "]";
	}
	
}
