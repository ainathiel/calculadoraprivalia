package com.privalia.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.privalia.model.Student;
import com.privalia.util.Config;
import com.privalia.util.FileWriterUtil;

public class StudentDao extends BaseDao implements IDao<Student>, INio<Student>
 {
	static String path = null;
	private Connection connect;


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
	
	public int addWithDataBase(Student student) throws SQLException {
		int idStudent = 0;
		PreparedStatement preparedStatement = null;
		ResultSet rsKey = null;
		try {
			connect = super.getConnection();
			preparedStatement = connect
					.prepareStatement("INSERT INTO student(name, surname, age)" 
			+ " VALUE (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getSurname());
			preparedStatement.setInt(3, student.getAge());
			
			preparedStatement.executeUpdate();
			rsKey = preparedStatement.getGeneratedKeys();
			rsKey.next();
			idStudent = rsKey.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally
		{
			preparedStatement.close();
			rsKey.close();
			connect.close();
		}
		
		return idStudent;
	}
}