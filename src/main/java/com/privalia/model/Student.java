package com.privalia.model;

public class Student {

	private int idStudent;
	private String name;
	private String surname;
	private int age;
	
	static int numero;
	
	//Inicializador estático que inicializa los atributos
	//estáticos de la clase
	static{
		numero = 10;
	}
	
	
	/**
	 * @return the idStudent
	 */
	public int getIdStudent() {
		return idStudent;
	}
	/**
	 * @param idStudent the idStudent to set
	 */
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	public Student()
	{
		
	}
	
	public Student(int idStudent, String name,
			String surname, int age)
	{
		this.idStudent = idStudent;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
}
