package Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBUtil {

    private static String url;
    private static String id;
    private static String pw;

    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBUtil.class.getResourceAsStream("/application.properties"));

            String driver = properties.getProperty("driver");
            url = properties.getProperty("url");   // ← static 필드에 저장!
            id  = properties.getProperty("id");
            pw  = properties.getProperty("password");

            Class.forName(driver);

            System.out.println("url: " + url);     // 디버깅용
            System.out.println("driver: " + driver);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 호출마다 새 Connection 생성 (2단계에서 배운 올바른 구조)
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, id, pw);
    }

    public static void close(AutoCloseable... resources) {
        for (AutoCloseable res : resources) {
            if (res != null) {
                try { res.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
    }
}