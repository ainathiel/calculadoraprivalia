package com.privalia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:8889/privalia?user=root&password=root"
					);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
