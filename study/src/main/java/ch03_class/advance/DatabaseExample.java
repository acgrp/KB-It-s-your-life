package main.java.ch03_class.advance;

public class DatabaseExample {
    public static void main(String[] args) {

        Database Data = Database.getInstance();

        Data.connect();
        System.out.println(Data.getConnection());
        Data.close();
    }
}
