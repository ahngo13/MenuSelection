package com.menuselection.multi;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import org.junit.Test;

 public class DB_Test {
 @Test
 public void test() throws Exception {
     Class.forName("org.mariadb.jdbc.Driver"); // ������DB
     // Class.forName("com.mysql.jdbc.Driver"); MySQL

     Connection con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "tkdans123!");// ������DB
     // Connection con =     DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","passwd"); MySQL
     System.out.println(con);
     }
 } 