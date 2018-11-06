package com.gmail.kirillmarch6;

public class QuantityOverflowException extends Exception {

	@Override
	public String getMessage() {
		
		return "Добавление студента невозможно. Группа укомлектована!";
	}

	
}
