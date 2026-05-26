package main.java.ch17.sec01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("감자바");

        Stream<String> stream = set.stream();

        Iterator<String> iterator = stream.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
