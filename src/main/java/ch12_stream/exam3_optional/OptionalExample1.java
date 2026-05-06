package main.java.ch12_stream.exam3_optional;

import java.util.Optional;

public class OptionalExample1 {
    public static void main(String[] args) {


      /*
       Optional : "값이 있을 수도 있고, 없을 수도 있는(null)" 상태를
                   안전하게 표현하기 위한 객체 (null 대신 사용)

       - empty()      : 처음부터 빈 Optional 생성
       - of()         : null 절대 안됨 (바로 예외)
       - ofNullable() : null이면 empty로 처리
      */

        // 비어있는 Optional 생성
        // -> 내부에 값이 없는 상태(null을 감싼 개념)
        Optional<String> empty = Optional.empty();

        // null이 아닌 값으로 Optional 생성
        // -> 반드시 값이 있어야 함
        Optional<String> opt = Optional.of("Hello");
//        Optional<String> opt2 = Optional.of("Hello");
        // -> NullPointerException 발생

        // null일 수도 있는 값으로 Optional 객체 생성
        // -> 값이 null이면 Optional.empty()로 만들어줌
        String str = null;
        Optional<String> nullable = Optional.ofNullable(str);

        System.out.println("empty = " + empty);
        System.out.println("opt = " + opt);
        System.out.println("nullable = " + nullable);


    }
}
