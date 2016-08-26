package me.umov.model;

public enum DayWeekEnum {
	
	SUNDAY(1),
	MONDAY(2),
	TUESDAY(3),
	WEDNESDAY(4),
	THURSDAY(5),
	FRIDAY(6),
	SATURDAY(7),
	HOLIDAY(8);
	
	private final Integer value;
	
	
	private DayWeekEnum(Integer value) {
		this.value = value;
	}
	
	public static DayWeekEnum forCode(Integer value) {
		for (DayWeekEnum type : DayWeekEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

	public Integer getValue() {
		return value;
	}
	

}
