package main.java.ch09_collection_generic.collection.list.ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
    // 컬렉션 특징
    // 1) 크기 제한 X
    // 2) 추가, 수정, 삭제 등의 코드가 구현되어 있다.
    // 3) 객체만 저장 가능

    // List : 자료를 순차적으로 나열한 자료구조 (배열과 비슷)
    // - 특징 1 : 인덱스를 이용해서 순서를 구분
    // - 특징 2 : 순서가 구분되기 때문에 중복 데이터 저장 가능

    public void ex1() {
        // 다형성(업캐스팅)
        List list = new ArrayList();

        // 1. boolean add(E e) : 마지막 요소로 추가
        // E(Element) : 요소를 뜻하는 상직적인 글자(자료형 X)
        list.add("글자"); // String 객체

        // 기본 자료형이 저장되는 이유
        // -> Wrapper class : 기본 자료형 -> 객체로 포장하는 클래스

        // Auto Boxing
        list.add(123); // int -> Integer
        list.add(3.14); // double -> Double

        // * 컬렉션에 저장되는 객체의 타입 제한 X
        System.out.println(list);

        list.add("리스트의 크기(3) 초과");
        System.out.println(list);
        // -> list의 크기를 초과해도
        //      자동으로 크기가 늘어나기 때문에 에러 발생 X

        // 2. E get(int index) : 지정한 index요소 얻어오기
        System.out.println(list.get(0));
        System.out.println(list.get(1));

        System.out.println("------------------------------");

        // 진짜로 자동 포장(Auto Boxing)이 되었는지 확인
        // a instanceof b : a가 b타입이거나 b의 자식(하위 타입)이라면 true
        System.out.println(list.get(1) instanceof Integer);
        System.out.println(list.get(2) instanceof Double);
        System.out.println(list.get(2) instanceof Object);

        // List + for문 + if + instanceof + 다운캐스팅

        // int list.size() : 저장된 객체의 개수를 반환
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof String) {
                String str = (String) list.get(i);
                System.out.println(str.charAt(0));
            }
            if(list.get(i) instanceof Integer){
                // Auto Unboxing
                int num = (Integer) list.get(i);
                // int = Integer
                //       Integer -> int
                System.out.println(100 + num);
            }

            // Double 인 경우
            if(list.get(i) instanceof Double) {
                Double d = (Double) list.get(i); // 다운 캐스팅 진행

                System.out.println(Double.BYTES);
            }
        }
    }

    public void ex2() {
        // 컬렉션의 장점 중 "여러타입 저장 가능" 때문에
        // instanceof로 타입 검사를 해야하는 코드가 추가되어
        // 코드의 길이가 늘어나는 문제점 발생

        // -> 타입을 하나로 제한하자!
        // --> Generics(제네릭)을 이용

        // String으로 타입이 제한된 List
        List<String> list = new ArrayList<>();
        // 타입 추론
        // ArrayList<>에 타입 미작성 시
        // 부모의 제네릭 <String>을 보고
        // String만 들어올 수 있게 함

        list.add("딸기빙수");
        list.add("치즈케이크");
//        list.add(500); // String 타입이 아니여서 에러 발생
    }
}
