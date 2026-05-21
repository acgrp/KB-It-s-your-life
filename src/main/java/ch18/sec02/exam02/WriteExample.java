package main.java.ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        byte[] array = {10, 20, 30};

        try(OutputStream os = new FileOutputStream("c:/temp/test2.db")){
            os.write(array);

            os.flush();
            System.out.println("배열 데이터 저장 완료");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
