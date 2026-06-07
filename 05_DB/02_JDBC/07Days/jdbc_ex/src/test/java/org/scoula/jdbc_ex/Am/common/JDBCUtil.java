package org.scoula.jdbc_ex.Am.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    static Connection conn = null;
    static {
        try{
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = properties.getProperty("driver"); // 데이터베이스 접속에 필요한 정보를 추출하는 것:
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url,username, password); // Connection 객체를 보관하는 것

        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        return conn;
    }

    public static void close(){
        if(conn != null){
            try {
                conn.close();
                conn=null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
