package edu.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    // 수업 JDBCUtil 참고하여 작성

    static Connection conn = null;

    static {

        Properties properties = new Properties();

        try{
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));

            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String pw = properties.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, pw);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() { return conn; }

    public static void close(){

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn=null;
        }

    }

}
