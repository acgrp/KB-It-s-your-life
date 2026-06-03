package org.edu.member.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    static Connection conn = null;

    static {
        Properties properties = new Properties();

        try {
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));

            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String pw = properties.getProperty("pw");

            Class.forName(driver);
            conn= DriverManager.getConnection(url,id,pw);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        return conn;
    }

    public static void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conn=null;
        }
    }
}
