package main.java.ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
    public static int sum; // 합계를구하기위한변수

    public static void main(String[] args) {

        IntStream.rangeClosed(1, 100).forEach(i -> sum += i);
        System.out.println(sum);
        //IntStream.range(1, 100)1 ~ 99 (끝 미포함)
        //IntStream.rangeClosed(1, 100)1 ~ 100 (끝 포함)
    }
}