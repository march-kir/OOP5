package com.gmail.kirillmarch6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class Group implements Voenkom, Serializable {

	List<Student> group = new ArrayList<>();
	final Integer sizeGroup = 10;

	public Group(List<Student> group) {
		super();
		this.group = group;
	}

	public Group() {
		super();
	}

	public List<Student> getGroup() {
		return group;
	}

	public void setGroup(List<Student> group) {
		this.group = group;
	}

	public Integer getSizeGroup() {
		return sizeGroup;
	}

	public void addStudent(Student student) {// ���������� ��������
		try {
			if (group.size() == sizeGroup) {
				throw new QuantityOverflowException();
			} else {
				group.add(student);
				System.out.println("�������� ������� " + student.getInformation());
			}
		} catch (QuantityOverflowException e) {
			System.out.println(e.getMessage());
		}

	}

	public void interactiveAddingStudent() {// ������������� ���� �������� � ���������� � ���������� ��� � ������
		Student s = new Student();
		try {
			s.setSurname(interactiveAddingStudentSurname());
			s.setName(interactiveAddingStudentName());
			s.setPatronymic(interactiveAddingStudentPatronimic());
			s.setAge(Integer.valueOf(JOptionPane.showInputDialog("������� �������")));
			s.setSex(Sex.valueOf(interactiveAddingStudentSex()));
			s.setStudentID(Integer.valueOf(JOptionPane.showInputDialog("������� ����� ������������� ������")));
			s.setNumberRecordBook(Integer.valueOf(JOptionPane.showInputDialog("������� ����� �������� ������")));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "������ ���� �����!");
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "������ �� ���� ������� ��� ������ ������!");
		}
		if (s.getSurname() != null) {
			addStudent(s);
		}
	}

	public String interactiveAddingStudentSurname() {
		String surname = "";
		surname = JOptionPane.showInputDialog("������� �������");
		if (surname.equals("")) {
			throw new NullPointerException();
		} else {
			return surname;
		}
	}

	public String interactiveAddingStudentName() {
		String name = "";
		name = JOptionPane.showInputDialog("������� ���");
		if (name.equals("")) {
			throw new NullPointerException();
		} else {
			return name;
		}
	}

	public String interactiveAddingStudentPatronimic() {
		String patronymic = "";
		patronymic = JOptionPane.showInputDialog("������� ��������");
		if (patronymic.equals("")) {
			throw new NullPointerException();
		} else {
			return patronymic;
		}
	}

	public String interactiveAddingStudentSex() {
		String sex = "";
		sex = String.valueOf(JOptionPane.showInputDialog("������� ��� (man/woman)"));
		try {
			if (sex.equals("man") || sex.equals("woman")) {
				return sex;
			} else {
				throw new NoSexExcaption();
			}
		} catch (NoSexExcaption e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	public void deleteStudent(Student student) {// �������� �������� �� ������
		Iterator<Student> itr = group.iterator();
		for (; itr.hasNext();) {
			Student element = itr.next();
			if (element.equals(student)) {
				System.out.println("������ ������� " + student.getInformation());
				itr.remove();
				break;
			}
		}
		if (itr.hasNext() == false) {
			System.out.println("������� ������� �������� ��������. � ������ ��� ������ ��������!");
		}
	}

	public Student searchStudent(String findStudnent) {// ����� �������� �� �������
		Student searchStudent = null;
		for (Student student : group) {
			if (findStudnent.equals(student.getSurname())) {
				searchStudent = student;
			}
		}
		return searchStudent;
	}
	
	public void getInformation() { // ����� ���������� � ��������
		for (Student student : group) {
			System.out.println(student.getInformation());
		}
	}
	
	public List<Student> getStudnetsForVoenkom() {	// ����������	
		List<Student> year18men = new ArrayList<>();
		for (Student student : group) {
			if (student.getAge() == 18 && student.getSex() == Sex.man) {
				year18men.add(student);
			}
		}
		return year18men;
	}
	
	
	public void saveStringToFile(Group group) { // ������ � ����
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("group_students"))) {
			oos.writeObject(group);
		} catch (IOException e) {
			System.out.println("���������� ��������� ������ � ����!");
		}
	}
	
	public Group getGroupFromFile(Group groupFromFile) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("group_students"))) {
			groupFromFile = (Group) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("���������� ������� ������ �� �����!");
		}
		return groupFromFile;
	}
}
