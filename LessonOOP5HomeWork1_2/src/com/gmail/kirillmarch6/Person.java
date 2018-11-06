package com.gmail.kirillmarch6;

import java.io.Serializable;

public class Person implements Serializable {
	
	private String surname;
	private String name;
	private String patronymic;
	private int age;
	private Sex sex;
	public Person(String surname, String name, String patronymic, int age, Sex sex) {
		super();	
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.age = age;
		this.sex = sex;
	}
	public Person() {
		super();
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	
	public String getInformation() {
		return "[surname=" + surname + ", name=" + name + ", patronymic=" + patronymic + ", age=" + age
				+ ", sex=" + sex;
	}
	
	

}
