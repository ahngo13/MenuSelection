package com.menuselection.multicam;

import java.sql.Connection;
import java.sql.DriverManager;
 
import org.junit.Test;
 
/*
 * MySQlConnectionTest
 * @Test
 */
public class MySQLConnectionTest {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/springdb?useSSL=false";
    private static final String USER = "bybit";
    private static final String PW = "bybit";
    
    @Test
    public void testConnection() throws Exception {
        Class.forName(DRIVER);
        
        // AutoCloseable 인터페이스를 구현한 타입의 변수
        try(Connection conn1 = DriverManager.getConnection(URL, USER, PW);
            Connection conn2 = DriverManager.getConnection(URL, USER, PW);) {
            
            System.out.println("===== mysql connection test start =====");
            System.out.println(conn1);
            System.out.println(conn2);
            System.out.println("===== mysql connection test end =====");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
