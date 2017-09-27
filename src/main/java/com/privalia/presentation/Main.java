package com.privalia.presentation;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.privalia.model.Student;
import com.privalia.util.MethodInfo;

public class Main {
	//final: no heredable y no modificable
	//.class utilizará REFLECTION en tiempo de ejecución
	static final Logger logger = Logger.getLogger(Main.class);

	@MethodInfo(author = "Francisco",
			revision = 4,
			comments = "My firts comment",
			date = "22/09/2017")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = true;
		while (exit ) {
			System.out.println("1. Agregar nuevo Alumno");
			System.out.println("2. Salir");
			switch(sc.nextInt()){    
			case 1:
				Student student = new Student();
				logger.info("1.1 Nombre");
				student.setName(sc.next());
				logger.info("1.2 Apellido");
				student.setSurname(sc.next());
				logger.info("1.3 Edad");
				student.setAge(sc.nextInt());
				
				logger.info("Name: " + student.getName());
				logger.info("Surname: " + student.getSurname());
				logger.info("Age: " + student.getAge());
				
				break;
			case 2:
				exit = false;   
				break;  		    
			default:     
				logger.info("Invalid option"); 
			}
		}
		logger.info("1. Agregar nuevo Alumno");
		logger.info("2. Salir");
		sc.close();
	}

}
