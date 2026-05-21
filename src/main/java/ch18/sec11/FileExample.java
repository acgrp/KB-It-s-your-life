package main.java.ch18.sec11;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        // 1. 확인할 파일 경로 지정 및 File 객체 생성
        File file = new File("C:/temp/file1.txt");

        // 2. 파일이나 디렉터리가 실제로 존재치 않는지 확인
        if (file.exists()) {

            // 3. 존재한다면 파일인지 디렉터리인지 구분
            if (file.isFile()) {
                // 파일인 경우: 파일 경로와 파일 크기(바이트) 출력
                System.out.println("파일 경로: " + file.getPath());
                System.out.println("파일 크기: " + file.length() + " bytes");
            } else if (file.isDirectory()) {
                // 디렉터리인 경우: "<dir> 파일 경로" 형태로 출력
                System.out.println("<dir> " + file.getPath());
            }

        } else {
            // 4. 존재하지 않는 경우 메시지 출력
            System.out.println("해당 파일은 없는 파일입니다.");
        }
    }
}
