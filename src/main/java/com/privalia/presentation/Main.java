package com.privalia.presentation;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.privalia.dao.IDao;
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
						Student student = setStudentData(reader);
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

	private static void printMainMenu() {
		logger.info("-----------------------------");
		logger.info("MAIN MENU");
		logger.info("1. Add new student.");
		logger.info("2. Exit");
	}

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
		message.append(newLine);
		message.append("UUID: ");
		message.append(student.getUUID().toString());

		logger.info(message.toString());
	}

	private static Student setStudentData(Scanner reader) {
		logger.info("Name: ");
		String name = reader.next();
		logger.info("Surname: ");
		String surname = reader.next();
		logger.info("Student Id: ");
		String inputId = reader.next();
		logger.info("Age: ");
		String inputAge = reader.next();

		return new Student(Integer.parseInt(inputId), name, surname, Integer.parseInt(inputAge), UUID.randomUUID());
	}

	private static void save(Student student) {
		try {
			IDao<Student> studentDao = new StudentDao();
			studentDao.addWithNio(student);
			logger.info("Student data has been saved succesfully.");
		} catch (IOException e) {
			logger.error("Error saving data");
		}
	}
}
