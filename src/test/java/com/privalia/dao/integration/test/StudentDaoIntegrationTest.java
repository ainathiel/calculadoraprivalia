package com.privalia.dao.integration.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.junit.Test;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.privalia.dao.IDao;
import com.privalia.dao.INio;
import com.privalia.dao.StudentDao;
import com.privalia.model.Student;
import com.privalia.util.Config;
import com.privalia.util.FileReaderUtil;

public class StudentDaoIntegrationTest {
	Student studentSent;
	String path;
	static final Logger logger = Logger.getLogger(StudentDaoIntegrationTest.class);

	@Before
	public void initialize() throws IOException {
		this.studentSent = getStudent();
		this.path = Config.getValue("students.path");
	}
	
	@BeforeClass
	public static void setup() {
		Properties properties = new Properties();
		String fileName = "config.properties";
		ClassLoader classLoader = Config.class.getClassLoader();
		URL resource = classLoader.getResource(fileName);
		try (FileInputStream fileInputStream = new FileInputStream(resource.getFile())) {
			properties.load(fileInputStream);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	@After
	public void deleteFile() {
		File file = new File(this.path);
		if (file.exists()) {
			file.delete();
		}
	}

	@Test
	public void testAddWithNioReadingWithNewByteChannel() throws IOException {
		INio<Student> studentDao = new StudentDao();
		int studentId = studentDao.addWithNio(this.studentSent);
		List<String> lines = FileReaderUtil.readWithNioUsingNewByteChannel(this.path);
		Student studentFromFile = null;
		for(String line : lines) {
			String[] studentData = line.toString().trim().split(",");
			if(studentId == Integer.parseInt(studentData[0])) {
				studentFromFile = new Student(
					Integer.parseInt(studentData[0]),
					studentData[1],
					studentData[2],
					Integer.parseInt(studentData[3]),
					UUID.fromString(studentData[4]));
				break;
			}
		}
		
		assertTrue(this.studentSent.equals(studentFromFile));
		assertEquals(studentId, studentFromFile.getIdStudent());
		assertEquals(this.studentSent.getUUID(), studentFromFile.getUUID());
		assertEquals(this.studentSent.hashCode(), studentFromFile.hashCode());
	}

	@Test
	public void testAddWithNio() throws IOException {
		INio<Student> studentDao = new StudentDao();
		int studentId = studentDao.addWithNio(this.studentSent);
		List<String> lines = FileReaderUtil.readWithNio(this.path);
		Student studentFromFile = null;
		for(String line : lines) {
			String[] studentData = line.toString().trim().split(",");
			if(studentId == Integer.parseInt(studentData[0])) {
				studentFromFile = new Student(
					Integer.parseInt(studentData[0]),
					studentData[1],
					studentData[2],
					Integer.parseInt(studentData[3]),
					UUID.fromString(studentData[4]));
				break;
			}
		}
		
		assertTrue(this.studentSent.equals(studentFromFile));
		assertEquals(studentId, studentFromFile.getIdStudent());
		assertEquals(this.studentSent.getUUID(), studentFromFile.getUUID());
		assertEquals(this.studentSent.hashCode(), studentFromFile.hashCode());
	}

	@Test
	public void testAdd() throws IOException {
		IDao<Student> studentDao = new StudentDao();
		studentDao.add(this.studentSent);

		String line = FileReaderUtil.read(this.path);		
		String[] studentData = line.split(",");
		Student studentFromFile = new Student(
				Integer.parseInt(studentData[0]),
				studentData[1],
				studentData[2],
				Integer.parseInt(studentData[3]),
				UUID.fromString(studentData[4]));
		
		assertTrue(this.studentSent.equals(studentFromFile));
		assertEquals(this.studentSent.toString(), line);
		assertEquals(this.studentSent.hashCode(), studentFromFile.hashCode());
	}

	static Student getStudent() {
		Student student = new Student();
		student.setName("Fernando");
		student.setSurname("Alonso");
		student.setAge(23);
		student.setIdStudent(239087);

		return student;
	}
}
