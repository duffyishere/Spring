package org.duffy.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	@Test
	public void connTest() {
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/db_board?serverTimezone=UTC",
				"root",
				"s2717244")){
			
			log.info(conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
