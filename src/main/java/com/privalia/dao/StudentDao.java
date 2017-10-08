package com.privalia.dao;

import java.io.IOException;
import com.privalia.model.Student;
import com.privalia.util.Config;
import com.privalia.util.FileWriterUtil;

public class StudentDao implements IDao<Student>, INio<Student> {
	static String path = null;


	static {
		path = Config.getValue("students.path");
	}

	@Override
	public int add(Student student) throws IOException {
		FileWriterUtil.write(path, student.toString());
		return student.getIdStudent();
	}
	
	@Override
	public int addWithNio(Student student) throws IOException {
		FileWriterUtil.writeWithNio(path, student.toString());
		return student.getIdStudent();
	}
}