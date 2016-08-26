package me.umov.model;


public class Person {
	private PersonType type;
	private Integer age; 
	private Boolean studentCard = Boolean.FALSE;
	
	
	public enum PersonType {
		CHILD(1),
		SENIOR(2),
		STUDENT(3),
		NORMAL(4);
		
		private final Integer code;
		
		private PersonType(int code) {
			this.code = code;
		}
		
		public static PersonType forCode(Integer code) {
			for (PersonType personType : PersonType.values()) {
				if (personType.getCode().equals(code)) {
					return personType;
				}
			}
			return null;
		}
		

		public Integer getCode() {
			return code;
		}
	}
	


	public PersonType getType() {
		return type;
	}


	public void setType(PersonType type) {
		this.type = type;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Boolean getStudentCard() {
		return studentCard;
	}


	public void setStudentCard(Boolean studentCard) {
		this.studentCard = studentCard;
	}
}
