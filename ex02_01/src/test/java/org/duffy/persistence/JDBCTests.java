package org.duffy.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class JDBCTests {

    @Test
    public void connectionTest(){
        try(Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@10.211.55.3:1521:XE",
                "book_ex",
                "book_ex")){

            log.info(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
