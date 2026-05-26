package main.java.ch18.sec07.exam01;

import java.io.*;

public class BufferExample {

    public static void main(String[] args) {

        String originalFilePath = "c:/temp/originalFile1.jpg";
        String targetFilePath = "c:/temp/originalFile2.jpg";

        // 주 스트림에 버퍼 보조 스트림 연결 (try-with-resources)
        try (
                InputStream fis = new FileInputStream(originalFilePath);
                BufferedInputStream bis = new BufferedInputStream(fis);

                OutputStream fos = new FileOutputStream(targetFilePath);
                BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            // 복사 시작 시간 기록 (밀리초 단위 수집)
            long startTime = System.currentTimeMillis();

            byte[] data = new byte[1024];
            while (true) {
                int num = bis.read(data); // 버퍼 보조 스트림을 통해 읽기
                if (num == -1) break;
                bos.write(data, 0, num); // 버퍼 보조 스트림을 통해 쓰기
            }
            bos.flush(); // 버퍼에 남은 데이터 모두 출력

            // 복사 종료 시간 기록
            long endTime = System.currentTimeMillis();

            System.out.println("복사가 성공적으로 완료되었습니다.");
            System.out.println("복사 소요 시간: " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}