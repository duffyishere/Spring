package org.duffy.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class JDBCTests {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try (Connection conn = DriverManager.getConnection(
                             "jdbc:mysql://localhost:3306/db_board?serverTimezone=Asia/Seoul",
                             "root",
                             "s2717244")) {

            log.info(conn);
        } catch (Exception e) {

            log.error(e.getMessage());
        }
    }
}

