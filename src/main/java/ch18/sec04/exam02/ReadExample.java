package main.java.ch18.sec04.exam02;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {
    public static void main(String[] args) {

        // 1. 한 번은 한 글자씩 처리
        try (Reader reader = new FileReader("c:/temp/test.txt")) {
            while (true) {
                int data = reader.read(); // 한 글자(2바이트)씩 읽어옴
                if (data == -1) break;    // 파일 끝에 도달하면 종료
                System.out.println((char) data); // char로 형변환하여 출력
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 2. 한 번은 글자 배열로 처리
        System.out.println("--- 방식 2: 글자 배열로 읽기 ---");
        try (Reader reader = new FileReader("c:/temp/test.txt")) {
            char[] data = new char[100]; // 글자를 담을 배열 생성

            while (true) {
                int num = reader.read(data); // 배열 크기만큼 읽어오고 읽은 문자 수 반환
                if (num == -1) break;        // 파일 끝에 도달하면 종료

                // 읽어온 실제 문자 수(num)만큼만 반복하며 출력
                for (int i = 0; i < num; i++) {
                    System.out.print(data[i]);
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}