package com.privalia.presentation;

import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.privalia.dao.IStudentDao;
import com.privalia.dao.StudentDao;
import com.privalia.model.Student;
import com.privalia.util.MethodInfo;

public class Main {
	static final Logger logger = Logger.getLogger(Main.class);

	@MethodInfo(author = "Nilla", revision = 1, comments = "My firts comment", date = "22/09/2017")
	public static void main(String[] args) {
		try (Scanner reader = new Scanner(System.in);) {
			boolean exit = false;

			while (!exit) {
				try {
					printMainMenu();
					int menuOption = reader.nextInt();
					switch (menuOption) {
					case 1:
						Student student = new Student();
						setStudentData(reader, student);
						printStudentData(student);
						save(student);
						break;
					case 2:
						exit = true;
						break;
					default:
						logger.info("Invalid option");
					}
				} catch (NumberFormatException e) {
					logger.error("Invalid type. Please try again.");
				}
			}

		}
		printMainMenu();
	}

	@MethodInfo(author = "Nilla", revision = 1, comments = "Print main menu", date = "01/10/2017")
	private static void printMainMenu() {
		logger.info("-----------------------------");
		logger.info("MAIN MENU");
		logger.info("1. Add new student.");
		logger.info("2. Exit");
	}

	@MethodInfo(author = "Nilla", revision = 1, comments = "Print student data", date = "01/10/2017")
	private static void printStudentData(Student student) {
		String newLine = "\n";
		StringBuilder message = new StringBuilder();
		message.append(newLine);
		message.append("Name: ");
		message.append(student.getName());
		message.append(newLine);
		message.append("Surname: ");
		message.append(student.getSurname());
		message.append(newLine);
		message.append("Student Id: ");
		message.append(student.getIdStudent());
		message.append(newLine);
		message.append("Age: ");
		message.append(Integer.toString(student.getAge()));

		logger.info(message.toString());
	}

	@MethodInfo(author = "Nilla", revision = 1, comments = "Set student data", date = "01/10/2017")
	private static void setStudentData(Scanner reader, Student student) {
		logger.info("Name: ");
		student.setName(reader.next());
		logger.info("Surname: ");
		student.setSurname(reader.next());
		logger.info("Student Id: ");
		String inputId = reader.next();
		student.setIdStudent(Integer.parseInt(inputId));
		logger.info("Age: ");
		String inputAge = reader.next();
		student.setAge(Integer.parseInt(inputAge));
	}

	@MethodInfo(author = "Nilla", revision = 1, comments = "Add student data in a file.", date = "01/10/2017")
	private static void save(Student student) {
		try {
			IStudentDao studentDao = new StudentDao();
			studentDao.add(student);
			logger.info("Student data has been saved succesfully.");
		} catch (IOException e) {
			logger.error("Error saving data");
		}
	}
}
