package com.gmail.kirillmarch6;

import java.util.Comparator;

import javax.swing.JOptionPane;

public class ParameterComparator implements Comparator<Student> {

	String parametr = "";
	
	
	
	public ParameterComparator(String parametr) {
		super();
		this.parametr = parametr;
	}



	public ParameterComparator() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the parametr
	 */
	public String getParametr() {
		return parametr;
	}



	/**
	 * @param parametr the parametr to set
	 */
	public void setParametr(String parametr) {
		try {
			this.parametr = parametr;
			if (this.parametr.equals("")) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Ничего не было введено или нажата отмена!");
		}
		if (!this.parametr.equals("surname") && !this.parametr.equals("name") && !this.parametr.equals("patronymic")
				&& !this.parametr.equals("age") && !this.parametr.equals("studentID") && !this.parametr.equals("numberRecordBook")) {
			System.out.println("Неверный параметр!");
		}
	}



	public int compare(Student a, Student b) {
		if (parametr.equals("surname")) {
			return a.getSurname().compareToIgnoreCase(b.getSurname());
		} else if (parametr.equals("name")) {
			return a.getName().compareToIgnoreCase(b.getName());
		} else if (parametr.equals("patronymic")) {
			return a.getPatronymic().compareToIgnoreCase(b.getPatronymic());
		} else if (parametr.equals("numberRecordBook") && a.getNumberRecordBook() < b.getNumberRecordBook()) {
			return 1;
		} else if (parametr.equals("numberRecordBook") && a.getNumberRecordBook() > b.getNumberRecordBook()) {
			return -1;
		} else if (parametr.equals("studentID") && a.getStudentID() < b.getStudentID()) {
			return 1;
		} else if (parametr.equals("studentID") && a.getStudentID() > b.getStudentID()) {
			return -1;
		} else if (parametr.equals("age") && a.getAge() < b.getAge()) {
			return 1;
		} else if (parametr.equals("age") && a.getAge() > b.getAge()) {
			return -1;
		} else {
			return 0;
		}
	}
}
