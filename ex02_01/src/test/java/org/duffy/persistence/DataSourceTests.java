package org.duffy.persistence;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class DataSourceTests {

    @Setter(onMethod_ = {@Autowired})
    private DataSource dataSource;

    @Setter(onMethod_ = {@Autowired})
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection(){
        try(Connection connection = dataSource.getConnection()){

            log.info(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testMyBatis(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession();
            Connection connection = sqlSession.getConnection()){

            log.info(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
