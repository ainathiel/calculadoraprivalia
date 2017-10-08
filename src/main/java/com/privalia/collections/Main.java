package com.privalia.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		Address address = new Address();
		address.setCity("Barcelona");
		address.setStreet("Corsega");
		address.setTown("Barcelona");
		
		Student student = new Student(address);
		student.setName("Nilla");
		student.setSurname("Ruggiero");
		student.setIdStudent(1234);
		student.setAge(23);
		
		List studentsList = new ArrayList();
		int counter = 4;
		
		//Ejemplo de boxing
		studentsList.add(student);
		//Ejemplo de autoboxing
		studentsList.add(counter);
		
		//Ejemplo unboxing
		Student newStudent = (Student)studentsList.get(0);
		String name = ((Student) studentsList.get(0)).getName();
		
		//Lista generica
		List<Student> genericStudentList = new ArrayList<Student>();
		genericStudentList.add(student);
		
		Student newStudent2 = genericStudentList.get(0);
		Optional<Student> optionalStudent = genericStudentList.stream().filter(
				p->p.getName().equals("Pepe")
			).findFirst();
		Student searchedStudent = optionalStudent.get();

	}

}
