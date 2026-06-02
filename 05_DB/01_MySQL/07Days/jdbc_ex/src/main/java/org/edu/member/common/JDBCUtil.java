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
            properties.load(org.scoula.jdbc_ex.Am.common.JDBCUtil.class.getResourceAsStream("/application.properties"));

            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("edu.id");
            String password = properties.getProperty("edu.pw");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, password);
            System.out.println(conn);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            System.out.println("exception");
        }
    }

    public static Connection getConnection() {
        return conn;
    }

    public static void close() {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conn = null;
        }
    }
}