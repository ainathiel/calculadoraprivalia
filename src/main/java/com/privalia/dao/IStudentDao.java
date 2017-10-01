package com.privalia.dao;

import java.io.IOException;

import com.privalia.model.Student;

public interface IStudentDao {
	int add(Student student) throws IOException;
}
