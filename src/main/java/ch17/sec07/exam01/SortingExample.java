package main.java.ch17.sec07.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortingExample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 30));
        studentList.add(new Student("신용권", 10));
        studentList.add(new Student("유미선", 20));

        //점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        Stream<Student> stream = studentList.stream().sorted();
        stream.forEach(s -> System.out.println(s.getName() + " : " + s.getScore()));
        System.out.println();

        //점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        Stream<Student> stream1 = studentList.stream().sorted(Comparator.reverseOrder());
        stream1.forEach(s -> System.out.println(s.getName() + " : " + s.getScore()));


    }
}
