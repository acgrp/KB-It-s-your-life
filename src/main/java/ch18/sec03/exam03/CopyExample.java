package main.java.ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) {
        String orininalFileName = "c:/temp/test.jpg";
        String targetFileName = "c:/temp/test2.jpg";


        try(InputStream is = new FileInputStream(orininalFileName);
            OutputStream os = new FileOutputStream(targetFileName)){

            byte[] data = new byte[1024];

            while(true){

                int num = is.read(data);

                if(num == -1) break;

                os.write(data, 0, num);
            }

            os.flush();
            System.out.println("복사 완료");
        } catch (Exception e) {
            System.out.println("복사중 오류");
            e.printStackTrace();
        }
    }
}
