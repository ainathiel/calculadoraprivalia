package com.privalia.dao.integration.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.UUID;

import org.junit.Test;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;

import com.privalia.dao.IDao;
import com.privalia.dao.StudentDao;
import com.privalia.model.Student;
import com.privalia.util.Config;
import com.privalia.util.FileReaderUtil;

public class StudentDaoIntegrationTest {
	Student student;
	String path;
	static final Logger logger = Logger.getLogger(StudentDaoIntegrationTest.class);

	@Before
	public void initialize() throws IOException {
		this.student = getStudent();
		this.path = Config.getValue("students.path");
	}
	
	@After
	public void deleteFile() {
		File file = new File(this.path);
		if (file.exists()) {
			file.delete();
		}
	}

	@Test
	public void testAddWithNio() throws IOException {
		IDao<Student> studentDao = new StudentDao();
		int studentId = studentDao.addWithNio(this.student);
		CharBuffer line =FileReaderUtil.readWithNio(this.path);
		String[] studentData = line.toString().trim().split(",");
		Student studentFromFile = new Student(
				Integer.parseInt(studentData[0]),
				studentData[1],
				studentData[2],
				Integer.parseInt(studentData[3]),
				UUID.fromString(studentData[4]));
		
		assertTrue(this.student.equals(studentFromFile));
		assertEquals(studentId, studentFromFile.getIdStudent());
		assertEquals(student.getUUID(), studentFromFile.getUUID());
		assertEquals(this.student.hashCode(), studentFromFile.hashCode());
	}

	@Test
	public void testAdd() throws IOException {
		IDao<Student> studentDao = new StudentDao();
		studentDao.add(this.student);

		String line = FileReaderUtil.read(this.path);
		
		String[] studentData = line.split(",");
		Student studentFromFile = new Student(
				Integer.parseInt(studentData[0]),
				studentData[1],
				studentData[2],
				Integer.parseInt(studentData[3]),
				UUID.fromString(studentData[4]));
		
		assertTrue(this.student.equals(studentFromFile));
		assertEquals(this.student.toString(), line);
		assertEquals(this.student.hashCode(), studentFromFile.hashCode());
	}
	
	
	/*public void testAddClase() throws IOException {
		Student alumnoEnviado = new Student(1, "Giuseppe", "Pesce", 43);
		StudentDao studentDao = new StudentDao();
		studentDao.add(alumnoEnviado);
		
		Student alumnoEncontrado = findAlumno(alumnoEnviado.getIdStudent());
		assertEquals(alumnoEncontrado, alumnoEnviado);
	}*/

	static Student getStudent() {
		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Castellanos");
		student.setAge(23);
		student.setIdStudent(239087);

		return student;
	}
	
	/** Código clase */
	/*private Student findAlumno(int idAlumno) throws IOException {
		File fichero = new File(this.path);//File.getFile(); //Implemetar getFile, es estático y está en memoria
		String[] alumnostring = null;
		boolean encontrado = false;
		
		try(Scanner s = new Scanner (fichero)) {
			while (s.hasNextLine() || encontrado == false) {
				String linea = s.nextLine();
				alumnostring = linea.split(",");
				if(Integer.parseInt(alumnostring[0]) == idAlumno) {
					encontrado = true;
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		Student studentFromFile = new Student();
		if(encontrado == true) {
			studentFromFile.setIdStudent(Integer.parseInt(alumnostring[0].trim()));
			studentFromFile.setName(alumnostring[1].trim());
			studentFromFile.setSurname(alumnostring[2].trim());
			studentFromFile.setAge(Integer.parseInt(alumnostring[3].trim()));
		} else {
			studentFromFile = null;
		}
		
		return studentFromFile;
	}*/
}
