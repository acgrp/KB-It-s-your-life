package main.java.ch18.sec04.exam01;

import java.io.*;

public class WriteExample {
    public static void main(String[] args) {
        char a = 'A';
        char b = 'B';
        char[] arr = {'C', 'D', 'E'};

        try(Writer writer = new FileWriter("c:/temp/test.txt")){

            writer.write(a);
            writer.write(b);

            writer.write(arr);

            writer.flush();
            System.out.println("저장 완료");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}