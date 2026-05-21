package main.java.ch13_IO.io.run;

import main.java.ch13_IO.io.service.IOService;
import main.java.ch13_IO.io.service.IOService2;

public class IORun {

    public static void main(String[] args) {

        IOService2 service = new IOService2();

        System.out.println(System.getProperty("user.dir"));
        // C:\KB_Back-master\KB_Back
        // JVM이 현재 작업 중인 폴더 경로 얻어줌
        // -> 상대경로의 기준위치가 어디인지 확인함
//        service.byteOutput();
        service.charOutput();
//        service.byteInput();
//        service.charInput();
    }
}
