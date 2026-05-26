package main.java.ch17.sec03;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        double avg = list.stream()
                .mapToInt(Student::getScore) // Student 객체에서 int 점수만(값 추출)
                .average()
                .getAsDouble(); // 이걸 사용해야 OptionalDouble에 들어가있는 average값을 반환 받음

        System.out.println("avg = " + avg);

    }
}
