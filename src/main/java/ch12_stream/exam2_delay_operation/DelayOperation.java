package main.java.ch12_stream.exam2_delay_operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DelayOperation {
    public static void main(String[] args) throws InterruptedException{

        List<String> names = Arrays.asList("홍길동", "김철수", "이영희", "Kim sara");

        // 스트림은 원본 컬렉션(names)을 변경하지 않고 새로운 흐름에서 데이터를 처리함.
        Stream<String> stream = names.stream()
                // filter() : 조건에 맞는 데이터만 통과시키는 중간 연산
                // 조건을 검사해서 true -> 다음 단계로 전달
                //               false -> 스트림에서 제거
                .filter(name ->{
                    System.out.println("filter : " + name);
                    return name.length() > 4;
                })

                // map() : 데이터를 변환하는 중간 연산
                // -> filter를 통과한 데이터만 들어옴
                // -> 입력값(name)을 받아서 다른 값으로 바꾼 후 반환
                .map(name -> {
                    System.out.println(" map= " + name);
                    return name.toLowerCase();
                });

        // 여기까지 아무 출력 없음
        // 왜? 스트림은 지연 연산(lazy)이라서
        // 최종 연산(forEach, collect)이 호출될 때만 실제로 실행된다!

        Thread.sleep(3000);

        // 최종 연산 호출 : filter -> map 순서로 각 요소가 하나씩 처리됨
        // collect() : 결과를 새로운 List로 수집

        // Collectors : Stream의 결과를 어떤 형태로 모을지 정해주는 도구 모음 클래스
        List<String> result = stream.collect(Collectors.toList());
        System.out.println(result);
        System.out.println(names);
//        stream.forEach(name -> System.out.println(name)); //람다식
//        stream.forEach(System.out::println); //메서드 참조
        //stream has already been operated upon or closed
        // (주의) 스트림은 1회용이라서 이후 재사용 불가
    }
}
