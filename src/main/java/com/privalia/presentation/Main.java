package com.privalia.presentation;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.privalia.model.Student;
import com.privalia.util.MethodInfo;

public class Main {
	static final Logger logger = Logger.getLogger(Main.class);

	@MethodInfo(author = "Francisco", revision = 4, comments = "My firts comment", date = "22/09/2017")
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			boolean exit = false;
			while (!exit) {
				logger.info("1. Agregar nuevo Alumno");
				logger.info("2. Salir");
				switch (sc.nextInt()) {
				case 1:
					Student student = new Student();
					logger.info("Nombre:");
					student.setName(sc.next());
					logger.info("Apellido:");
					student.setSurname(sc.next());
					logger.info("Edad:");
					student.setAge(sc.nextInt());

					logger.info("Name: ".concat(student.getName()));
					logger.info("Surname: ".concat(student.getSurname()));
					logger.info("Age: ".concat(Integer.toString(student.getAge())));

					break;
				case 2:
					exit = true;
					break;
				default:
					logger.info("Invalid option");
				}
			}
			logger.info("1. Agregar nuevo Alumno");
			logger.info("2. Salir");
		}
	}
}
