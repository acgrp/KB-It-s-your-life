package main.java.ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = 30;

        try(OutputStream os = new FileOutputStream("c:/temp/test1.db")){
            os.write(a);
            os.write(b);
            os.write(c);

            os.flush();
            System.out.println("저장 완료");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
