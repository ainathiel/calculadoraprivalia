package com.privalia.dao.integration.test;

import com.privalia.dao.BaseDao;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

public class BaseDaoIntegrationTest {
	@Test
	public void testConnectio() throws SQLException {
		BaseDao bd = new BaseDao();
		assertTrue(bd.getConnection()!= null);
	}
}
