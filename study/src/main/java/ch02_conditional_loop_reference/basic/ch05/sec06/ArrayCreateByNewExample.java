package main.java.ch02_conditional_loop_reference.basic.ch05.sec06;

import java.lang.reflect.Array;

public class ArrayCreateByNewExample {
    public static void main(String[] args) {

        int[] arr = new int[3];
        for (int i = 0; i< arr.length; i++){
            System.out.println(arr);
        }
        String[] arr2 = new String[3];
        for (int i = 0; i< arr2.length; i++){
            System.out.println(arr2);
        }
    }
}
