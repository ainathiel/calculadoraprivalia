package com.privalia.dao;

import java.io.IOException;
import com.privalia.model.Student;
import com.privalia.util.Config;
import com.privalia.util.File;

public class StudentDao implements IStudentDao {

	@Override
	public int add(Student student) throws IOException {
		String path = Config.getValue("students.path");
		File.create(path, student.toString());
		return 1;
	}	
}