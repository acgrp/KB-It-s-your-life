package main.java.ch18.sec02.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

    public static void main(String[] args) {

        try(InputStream is = new FileInputStream("c:/Temp/test2.db")){
            byte[] data = new byte[100];

            while(true){
                int num = is.read(data);
                if(num == -1) break;
            }
            
        }catch (IOException e){
            e.printStackTrace();
        }

        byte[] data;


    }
}
