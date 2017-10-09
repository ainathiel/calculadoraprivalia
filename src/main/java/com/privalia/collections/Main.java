package com.privalia.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;

public class Main {
	
	public static void main(String[] args) {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Teacher teacher1 = new Teacher();
		teacher1.setIdTeacher(1);
		teacher1.setName("Pepe");
		teacherList.add(teacher1);
		
		Teacher teacher2 = new Teacher();
		teacher2.setIdTeacher(1);
		teacher2.setName("Albert");
		teacherList.add(teacher2);
		
		Address address = new Address();
		address.setCity("Barcelona");
		address.setStreet("Corsega");
		address.setTown("Barcelona");
		
		Student student = new Student(address);
		student.setName("Nilla");
		student.setSurname("Ruggiero");
		student.setIdStudent(1234);
		student.setAge(23);
		student.setTeacher(teacherList);
		
		student.getTeacher().forEach(teacher->System.out.println(teacher.getName()));
		
		Map<Long, Product> productsList = new HashMap<Long, Product>();
		Product product1 = new Product();
		product1.setIdProduct(1);
		product1.setName("Product_1");
		
		Product product2 = new Product();
		product2.setIdProduct(1);
		product2.setName("Product_2");
		
		productsList.put(1L, product1);
		productsList.put(2L, product2);
		
		Category category = new Category();
		category.setIdCategory(1);
		category.setName("c1");
		category.setProducts(productsList);
		
		
		
		
	
	/*	List studentsList = new ArrayList();
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
		Student searchedStudent = optionalStudent.get();*/

	}

}
