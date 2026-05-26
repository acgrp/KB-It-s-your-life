package main.java.ch13_IO.io.service;

import java.io.*;

public class IOService {

    public static void main(String[] args) {

        IOService service = new IOService();
        /* IO
         *
         * Input(입력)
         * : 외부 -> 내부로 데이터를 들여오는 것
         *
         * Output(출력)
         * : 내부 -> 외부로 데이터를 내보내는 것
         *   (내부 == 프로그램, 외부 == 파일)
         *
         *
         * Stream(스트림)
         * : 데이터가 이동하는 통로
         *   (기본적으로 단방향)
         *
         *
         * [바이트 기반 스트림]
         * - InputStream / OutputStream 이 최상위 클래스
         *
         * - 1byte 단위로 데이터를 입출력하는 스트림
         *
         * - 영어, 숫자, 특수문자 같은 단순 문자 처리 가능
         * - 이미지, 영상, 오디오 같은 바이너리 데이터 처리에 사용
         *
         *
         * [문자 기반 스트림]
         * - Reader / Writer 가 최상위 클래스
         *
         * - 문자 단위로 데이터를 입출력하는 스트림
         *
         * - 문자열, 텍스트 파일 처리에 사용
         * - 한글 같은 문자 데이터를 다루기 적합
         *
         *
         * [기반 스트림]
         * - 직접 입출력을 수행할 수 있는 스트림
         *
         *
         * [보조 스트림]
         * - 기반 스트림의 성능 향상 또는 추가 기능 제공을 위한 스트림
         * - 단독 사용 불가능
         * - 반드시 기반 스트림과 함께 사용
         */


    }
    // 바이트 기반 파일 출력

    public void byteOutput() {

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("src/main/java/ch13_IO/io/byte/byteTest.txt", true);
            // 현재 프로그램에서 해당 경로에 byteTest.txt 파일로 출력하는 통로 객체 생성

            String content = "Hello 1234 !@#";

            for (int i = 0; i < content.length(); i++) {
//                 System.out.println(content.charAt(i));

                fos.write(content.charAt(i));
            }

            System.out.println("출력완료");

        } catch (IOException e) {
            // IO 관련된 코드는 IOException을 발생시킬 가능성이 높음

            System.out.println("예외 발생");
            e.printStackTrace(); // 예외가 발생한 메서드까지 모든 내용 출력
        } finally {
            //예외가 발생 하든 말든 무조건 수행

            // 사용한 스트림 자원 반환(통로 없앰) --> 필수 작성!
            // 프로그램 메모리 관리 차월에서 항상 다쓰면 끊어줌

            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    // 문자 기반 파일 출력
    public void charOutput() {
        FileWriter fw = null;

        try {
            fw = new FileWriter("src/main/java/ch13_IO/io/char/charTest.txt");
            // char 폴더에 charText.txt가 있으면 문자 출력 스트림 연결
            // 만약 파일이 없다면 해당 경로에 파일을 만들어서 연결

            String content = "곧 조 발표 합니다. 0_< ";

            fw.write(content); // 문자열을 통째로 내보냄
            // 한 줄을 통째로 내보내기 위해 "버퍼"를 이용하는데
            // 아직 버퍼에 담겨있음!

            // close() 구문을 수행하면 통로에 남아있는 내용을
            // 모두 내보내고 통로를 없앤다.

            System.out.println("출력 완료");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 바이트 기반 파일 입력
    public void byteInput() {
        FileInputStream fis = null;
        // 파일 -> 프로그램으로 읽어오는 바이트 기반 스트림

        try {
            fis = new FileInputStream("src/main/java/ch13_IO/io/byte/byteTest.txt");

            while(true){
                int data = fis.read();// 다음 1byte를 읽어오는데 정수형임
                                      // 다음 내용이 없으면 -1 반환
                if(data == -1) break;

                System.out.print((char)data);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 문자 기반 파일 입력
    public void charInput(){

        FileReader fr = null;

        try{
            fr = new FileReader("src/main/java/ch13_IO/io/char/charTest.txt");

            while(true){
                int data = fr.read();

                if(data == -1) break;

                System.out.print((char)data);
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {

            try {
                if (fr != null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
