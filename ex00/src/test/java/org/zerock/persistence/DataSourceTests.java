package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j 
public class DataSourceTests {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSessionFactory sqlSelssionFactory;
	
	@Test
	public void testConnection() {
		try(Connection conn = dataSource.getConnection()){
			
			log.info("==============================");
			log.info(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//omg mac... 
	//korean is broken  한글 .. 
	//어떤지 상황 보여주세요 
	//ex00 파일에서도 똑같이 에러가 나서 
//정상동작하는데요??\
// 서버는 원래 동작ㅇ ㅣ안되나요??
	@Test
	public void testConnection02() {
		
		try(SqlSession session =  sqlSelssionFactory.openSession();
			Connection conn = session.getConnection()){
			
			log.info(session);
			log.info(conn);
			
		}catch(Exception e) {
			e.printStackTrace(); 
		}
	}
}
