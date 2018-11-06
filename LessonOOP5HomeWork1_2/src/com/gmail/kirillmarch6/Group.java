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

	public void addStudent(Student student) {// добавление студента
		try {
			if (group.size() == sizeGroup) {
				throw new QuantityOverflowException();
			} else {
				group.add(student);
				System.out.println("Добавлен студент " + student.getInformation());
			}
		} catch (QuantityOverflowException e) {
			System.out.println(e.getMessage());
		}

	}

	public void interactiveAddingStudent() {// интерактивный ввод студента с клавиатуры и добавление его в массив
		Student s = new Student();
		try {
			s.setSurname(interactiveAddingStudentSurname());
			s.setName(interactiveAddingStudentName());
			s.setPatronymic(interactiveAddingStudentPatronimic());
			s.setAge(Integer.valueOf(JOptionPane.showInputDialog("Введите возраст")));
			s.setSex(Sex.valueOf(interactiveAddingStudentSex()));
			s.setStudentID(Integer.valueOf(JOptionPane.showInputDialog("Введите номер студенческого билета")));
			s.setNumberRecordBook(Integer.valueOf(JOptionPane.showInputDialog("Введите номер зачетной книжки")));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Должно быть число!");
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Ничего не было введено или нажата отмена!");
		}
		if (s.getSurname() != null) {
			addStudent(s);
		}
	}

	public String interactiveAddingStudentSurname() {
		String surname = "";
		surname = JOptionPane.showInputDialog("Введите фамилию");
		if (surname.equals("")) {
			throw new NullPointerException();
		} else {
			return surname;
		}
	}

	public String interactiveAddingStudentName() {
		String name = "";
		name = JOptionPane.showInputDialog("Введите имя");
		if (name.equals("")) {
			throw new NullPointerException();
		} else {
			return name;
		}
	}

	public String interactiveAddingStudentPatronimic() {
		String patronymic = "";
		patronymic = JOptionPane.showInputDialog("Введите отчество");
		if (patronymic.equals("")) {
			throw new NullPointerException();
		} else {
			return patronymic;
		}
	}

	public String interactiveAddingStudentSex() {
		String sex = "";
		sex = String.valueOf(JOptionPane.showInputDialog("Введите пол (man/woman)"));
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

	public void deleteStudent(Student student) {// удаление студента из группы
		Iterator<Student> itr = group.iterator();
		for (; itr.hasNext();) {
			Student element = itr.next();
			if (element.equals(student)) {
				System.out.println("Удален студент " + student.getInformation());
				itr.remove();
				break;
			}
		}
		if (itr.hasNext() == false) {
			System.out.println("Попытка удалить студента неудачна. В группе нет такого студента!");
		}
	}

	public Student searchStudent(String findStudnent) {// поиск студента по фамилии
		Student searchStudent = null;
		for (Student student : group) {
			if (findStudnent.equals(student.getSurname())) {
				searchStudent = student;
			}
		}
		return searchStudent;
	}
	
	public void getInformation() { // вывод информации о студенте
		for (Student student : group) {
			System.out.println(student.getInformation());
		}
	}
	
	public List<Student> getStudnetsForVoenkom() {	// призывники	
		List<Student> year18men = new ArrayList<>();
		for (Student student : group) {
			if (student.getAge() == 18 && student.getSex() == Sex.man) {
				year18men.add(student);
			}
		}
		return year18men;
	}
	
	
	public void saveStringToFile(Group group) { // запись в файл
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("group_students"))) {
			oos.writeObject(group);
		} catch (IOException e) {
			System.out.println("Невозможно сохранить группу в файл!");
		}
	}
	
	public Group getGroupFromFile(Group groupFromFile) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("group_students"))) {
			groupFromFile = (Group) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Невозможно создать группу из файла!");
		}
		return groupFromFile;
	}
}
