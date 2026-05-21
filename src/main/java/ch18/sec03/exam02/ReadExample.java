package main.java.ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

    public static void main(String[] args) {

        byte[] data = new byte[100];
        try(InputStream is = new FileInputStream("c:/Temp/test2.db")){

            while(true){
                int num = is.read(data);//num은 읽은 수
                if(num == -1) break;


                for(int i = 0; i < num; i++){
                    System.out.println(data[i]);
                }
            }
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
