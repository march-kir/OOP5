package com.gmail.kirillmarch6;

public class NoSexExcaption extends Exception {
	@Override
	public String getMessage() {
		
		return "Такого поля не существует!";
	}
}
