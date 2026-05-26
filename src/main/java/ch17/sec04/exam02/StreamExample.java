package main.java.ch17.sec04.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        String[] strArray = {"홍길동", "신용권", "김미나"};

        Stream<String> str = Arrays.stream(strArray);
        str.forEach(System.out::print);
        System.out.println();

        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArray);  //Integer이 아닌 IntStream으로 사용
        intStream.forEach(System.out::print);  // Integer도 가능하지만 boxed()를사용 -> 무거움

    }
}