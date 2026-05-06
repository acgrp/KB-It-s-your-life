package main.java.ch11_lamda.basic;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRef {
    public static void main(String[] args) {

        /* [메서드 참조]
      - 람다식으로 작성할 내용을 이미 존재하는 메서드로 대신 표현하는 문법
     -> 직접 람다식을 작성하지 않고, 동일한 기능을 하는 기존 메서드를 가져다 사용한다.

      - java.util.function : 람다식에서 사용하는 함수형 인터페이스 모음 패키지
        1. Function : 값을 받아서 다른 값으로 변환하는 함수
        2. Supplier : 입력 없이 값 하나 만들어서 반환하는 함수
        3. Consumer : 값을 받아서 사용만하고, 결과는 반환하지 않는 함수
        4. BinaryOperator : 같은 타입 두개를 받아서 같은 타입 하나를 반환하는 함수
     */

        // 정적 메서드 참조 - 절대값 구하기
        // 1. Function : 값을 받아서 다른 값으로 변환하는 함수
        // Function<Integer, Integer> : Integer 입력 -> Integer 결과

        // 1) 익명 클래스
        Function<Integer, Integer> abs1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer num) {
                return Math.abs(num);
            }
        };
        System.out.println("abs1 = " + abs1.apply(-10));

        // 2) 람다식 변환
        Function<Integer, Integer> abs2 = num -> Math.abs(num);
        System.out.println("abs2 = " + abs2.apply(-10));

        // 3) 메서드 참조 방식으로 변환
        // == 람다식 num -> Math.abs(num)와 같은 모양, 같은 역할의 메서드
        // int Math.abs(int num)
        Function<Integer, Integer> abs3 = Math::abs;
        System.out.println("abs3 = " + abs3.apply(-10));

        System.out.println("----------------------------------------");

        // 인스턴스 메서드 참조 - 소문자 바꾸기
        // 2. Supplier : 입력 없이 값 하나 만들어서 반환하는 함수

        // Supplier<String> : 입력 없음 -> String 하나 반환
        String str = "Hello World";

        Supplier<String> lower1 = new Supplier<String>() {
            @Override
            public String get() {
                return str.toLowerCase();
            }
        };

        System.out.println("lower1 = " + lower1.get());

        // 람다식
        Supplier<String> lower2 = () -> str.toLowerCase();
        System.out.println("lower2 = " + lower2.get());

        // 메서드 참조
        Supplier<String> lower3 = str::toLowerCase;

        // str 객체의 toLowerCase 메서드를 사용하겠다.
        System.out.println("lower3 = " + lower3.get());

        System.out.println("-------------------------------------");

        // 특정 타입의 인스턴스 메서드 참조 - 문자열 길이 반환
        Function<String, Integer> strLength1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println("str 길이 1 : " + strLength1.apply(str));

        // 2. 람다식 변환
        Function<String, Integer> strLength2 = s -> s.length();
        System.out.println("str 길이 2 = " + strLength2.apply(str));

        // 3. 메서드 참조방식으로 변환
        // int String.length(String str)
        Function<String, Integer> strLength3 = String::length;
        System.out.println("strLength3 = " + strLength3.apply(str));

        System.out.println("-----------------------------------");

        // 리스트 순차 접근 후 출력
        // List.of() : 값을 바로 넣어 수정 불가능한(immutable) 리스트를 만드는 방법
        List<String> list = List.of("A", "B", "C", "D");
        // list.add("E");
        // System.out.println(list);

        // Consumer : 값을 받아서 사용만하고, 결과는 반환하지 않는 함수
        // Consumer<String> : String 타입 입력 -> 결과(return) 없음

        Consumer<String> printList1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        System.out.println("printList1 = " + list);
        list.forEach(printList1);
        // 컬렉션명.forEach() : 향상된 for문처럼 요소를 반복 처리하지만 제어 불가(break/continue)

//        for (String s : list) {
//            printList1.accept(s);
//        }

        // 2, 람다식
        Consumer<String> printList2 = s -> System.out.println(s);
        System.out.println("printList2 = ");
        list.forEach(printList2);

        // 3. 메서드 참조
        System.out.println("printList3 : ");
        list.forEach(System.out::println);

        System.out.println("-----------------------------------");
        // 매개변수 메서드 참조
        // BinaryOperator : 같은 타입 두개를 받아서 같은 타입 하나를 반환하는 함수

        // 1. 익명 클래스
        BinaryOperator<Integer> operator1 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        System.out.println("sum1 : " + sumTwoNumber(operator1, 10, 20));

        // 2. 람다식 변환
        BinaryOperator<Integer> operator2 = (a, b) -> a + b;
        System.out.println("sum2 = " + operator2.apply(10, 20));

        // 3. 매개변수 메서드 참조로 변환
        System.out.println("sum3 : " + sumTwoNumber(MethodRef::sum, 10, 20));

        // 4. 정적 메서드 참조로 변환
        System.out.println("sum3 : " + sumTwoNumber(Integer::sum, 10, 20));


    }
    public static int sum(int num1, int num2){
        return num1 + num2;
    }

    public static int sumTwoNumber(BinaryOperator<Integer> op, int a, int b) {
        return op.apply(a, b);
    }
}
