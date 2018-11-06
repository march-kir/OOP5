package com.gmail.kirillmarch6;

import java.io.Serializable;

public class Student extends Person implements Comparable, Serializable {

	private int studentID;
	private int numberRecordBook;

	public Student(String surname, String name, String patronymic, int age, Sex sex, int studentID,
			int numberRecordBook) {
		super(surname, name, patronymic, age, sex);
		this.studentID = studentID;
		this.numberRecordBook = numberRecordBook;
	}

	public Student() {
		super();
	}

	public Student(String surname, String name, String patronymic, int age, Sex sex) {
		super(surname, name, patronymic, age, sex);
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getNumberRecordBook() {
		return numberRecordBook;
	}

	public void setNumberRecordBook(int numberRecordBook) {
		this.numberRecordBook = numberRecordBook;
	}

	@Override
	public String getInformation() {
		return "Student " + super.getInformation() + ", studentID=" + studentID + ", numberRecordBook="
				+ numberRecordBook + "]";
	}

	@Override
	public int compareTo(Object obj) {
		if (obj == null) {
			return -1;
		}
		Student tmp = (Student) obj;
		return this.getSurname().compareToIgnoreCase(tmp.getSurname());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Student other = (Student) obj;
		return studentID == other.studentID && numberRecordBook == other.numberRecordBook
				&& this.getAge() == other.getAge() && this.getSex() == other.getSex()
				&& (this.getSurname() == other.getSurname() || (this.getSurname() != null
						&& this.getSurname().equals(other.getSurname()))
						&& (this.getName() == other.getName() || (this.getName() != null
								&& this.getName().equals(other.getName()))
								&& (this.getPatronymic() == other.getPatronymic() || (this.getPatronymic() != null
										&& this.getPatronymic().equals(other.getPatronymic())))));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentID;
		result = prime * result + numberRecordBook;
		result = prime * result + this.getAge();
		result = prime * result + ((this.getSurname() == null) ? 0 : this.getSurname().hashCode());
		result = prime * result + ((this.getName() == null) ? 0 : this.getName().hashCode());
		result = prime * result + ((this.getPatronymic() == null) ? 0 : this.getPatronymic().hashCode());
		result = prime * result + ((this.getSex() == null) ? 0 : this.getSex().hashCode());
		return result;
	}

}