package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    @Test
    @DisplayName("jdbc_ex 데이터베이스에 접속한다.")
    public void testConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 생략가능
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex";
        String id = "scoula";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, id, password);
        // url, id, password를 이용해 통로 연결 한것을 conn으로 저장
        System.out.println("DB 연결 성공");
        conn.close();
    }

    @Test
    @DisplayName("jdbc_ex에 접속한다")
    public void testConnection2() throws SQLException{

        try(Connection conn = JDBCUtil.getConnection()){
            System.out.println("DB 연결 성공");
        }

    }
}
