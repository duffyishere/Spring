package org.duffy.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.duffy.persistence.JDBCTests;

import lombok.extern.log4j.Log4j;

	@Log4j
	public class JDBCTests {
		static {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void testConnection() {
			try(Connection conn =
				DriverManager.getConnection(
						"jdbc:oracle:thin:@10.211.55.3:1521:XE",
						"book_ex",
						"book_ex")) {
				
				log.info(conn);
				
			}catch(Exception e) {
				fail(e.getMessage());
			}
		}
		
}
