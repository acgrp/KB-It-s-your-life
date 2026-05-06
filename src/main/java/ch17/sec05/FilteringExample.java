package main.java.ch17.sec05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("감자바");
        list.add("신용권");
        list.add("신민철");
        //중복 요소 제거
        // 신으로 시작하는 요소만 필터링
        // 중복 요소를 먼저 제거하고, 신으로 시작하는 요소만 필터링

        Stream<String> stream = list.stream().distinct();
        stream.forEach(System.out::println);
        System.out.println();

        Stream<String> stream1 = list.stream().filter(s -> s.contains("신"));
        stream1.forEach(System.out::println);
        System.out.println();

        Stream<String> stream2 = list.stream().distinct().filter(s -> s.contains("신"));
        stream2.forEach(System.out::println);
    }
}
