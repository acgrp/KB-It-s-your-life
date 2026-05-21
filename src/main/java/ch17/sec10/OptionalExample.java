package main.java.ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        double avg;

        OptionalDouble opt = list.stream().mapToInt(Integer::intValue).average();

        avg = opt.orElse(0.0);

        System.out.println("평균: " + avg);

    }
}
