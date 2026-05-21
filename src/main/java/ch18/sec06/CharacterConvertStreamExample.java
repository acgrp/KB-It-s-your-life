package main.java.ch18.sec06;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CharacterConvertStreamExample {

    public static void main(String[] args) {
        String str = "문자 변환 스트림을 사용합니다.";
        String filePath = "c:/temp/text.txt";

        // 1. 문자열을 파일에 저장하기 (Write)
        // 주 스트림인 FileOutputStream에 보조 스트림인 OutputStreamWriter를 연결
        try(OutputStream os = new FileOutputStream(filePath);
            Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)){

            writer.write(str);// 보조 스트림을 통해 문자열 바로 저장
            writer.flush();
            System.out.println("저장 완료");
        }catch(Exception e){
            e.printStackTrace();
        }

        // 2. 파일에서 문자열 읽어와 출력하기 (Read)
        // 주 스트림인 FileInputStream에 보조 스트림인 InputStreamReader를 연결
        try(InputStream is = new FileInputStream(filePath);
        Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)){

            char[] data = new char[100];
            int num = reader.read(data);// 보조 스트림을 통해 문자를 배열로 읽기

            // 읽어온 문자 배열을 문자열로 변환하여 출력
            String readStr = new String(data, 0, num);
            System.out.println(readStr);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}