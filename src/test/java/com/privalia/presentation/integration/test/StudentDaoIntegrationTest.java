package com.privalia.presentation.integration.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import com.privalia.dao.IStudentDao;
import com.privalia.dao.StudentDao;
import com.privalia.model.Student;
import com.privalia.util.Config;

public class StudentDaoIntegrationTest {
	Student student;
	String path;

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
	public void testAdd() throws IOException {
		IStudentDao studentDao = new StudentDao();
		studentDao.add(this.student);

		FileReader fileReader = new FileReader(this.path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = bufferedReader.readLine();
		bufferedReader.close();
		fileReader.close();
		
		assertEquals(this.student.toString(), line);
	}

	static Student getStudent() {
		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Castellanos");
		student.setAge(23);
		student.setIdStudent(239087);

		return student;
	}
}
