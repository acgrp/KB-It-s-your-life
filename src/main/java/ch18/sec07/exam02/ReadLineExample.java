package main.java.ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadLineExample {
    public static void main(String[] args) {
        String filePath = "c:/temp/test3.txt";

        // 주 스트림(FileReader)에 성능 향상 보조 스트림(BufferedReader)을 연결
        try (
                Reader reader = new FileReader(filePath);
                BufferedReader br = new BufferedReader(reader)
        ) {
            int lineNo = 1; // 행 번호를 표시하기 위한 변수

            while (true) {
                // 한 줄을 통째로 읽어오기 (줄바꿈 문자 전까지)
                String line = br.readLine();

                // 파일 끝에 도달하여 더 이상 읽을 줄이 없으면 null 반환 -> 루프 탈출
                if (line == null) break;

                // 화면에 몇 번째 줄인지 번호와 함께 텍스트 출력
                System.out.println(lineNo + ": " + line);
                lineNo++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
