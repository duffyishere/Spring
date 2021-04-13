package org.duffy.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTets {

	@Test
	public void connTest() {
		try(Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.211.55.3:1521:XE",
				"book_ex",
				"book_ex")){
			
			log.info(conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
