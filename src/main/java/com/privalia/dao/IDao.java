package com.privalia.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface IDao<T> {
	int add(T model) throws IOException;
	int addWithNio(T model) throws IOException;
	int addWithDataBase(T model) throws SQLException;
}
