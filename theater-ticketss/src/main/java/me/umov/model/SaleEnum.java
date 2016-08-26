package me.umov.model;

public enum SaleEnum {
	
	FIVE(0.5),
	TEN(0.10),
	ELEVEN(0.11),
	FIFTEEN(0.15),
	THIRTY(0.30),
	THIRTY_FIVE(0.35),
	FORTY(0.40),
	FIFTY(0.50);
	
	private final Double value;
	
	
	private SaleEnum(Double value) {
		this.value = value;
	}
	
	public static SaleEnum forCode(Integer value) {
		for (SaleEnum type : SaleEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

	public Double getValue() {
		return value;
	}
	

}
