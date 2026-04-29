package main.java.ch03_class.advance;

public class Database {

    private static Database instance = new Database();

    private String connection = "MySQL";

    public static Database getInstance() {
        return instance;
    }

    public String getConnection() {
        return connection;
    }

    public String connect() {
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }
    public void close() {
        System.out.println(connection + "을 닫습니다.");
    }

}
