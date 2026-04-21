package main.java.ch03_class.basic.oop.model.service;

import main.java.ch03_class.basic.oop.model.vo.Apple;
import main.java.ch03_class.basic.oop.model.vo.Galaxy;
import main.java.ch03_class.basic.oop.model.vo.Phone;

public class InheritanceService {

    public void ex1() {
        //상속 확인
        // - Phone을 상속 받은 Apple이
        //Phone의 필드, 메서드 사용 가능한가?


        // 부모 - Phone
        Phone phone = new Phone();

        System.out.println(phone.getColor());
        System.out.println("----------------------");

        // 자식 - Apple
        Apple apple = new Apple();

        // Apple만의 고유한 메서드
        apple.setIosVersion("32.1 버전");

        apple.setColor("red");

        // 세팅된 값 출력
        System.out.println("apple = " + apple.getIosVersion());
        System.out.println("apple = " + apple.getColor());
    }

    public void ex2(){
        // 오버라이딩 확인 예제
        // 오버라이팅(OverRiding) : 부모로부터 물려받은 메소드를 자식이 재정의 하는 것

        Galaxy galaxy = new Galaxy();

        galaxy.pay(); // 오버라이딩 x -> Phone 메서드 수행
        //main.java.ch03_class.basic.oop.model.vo.Phone

        galaxy.pay(); // 오버라이딩 O -> Galaxy 메서드 수행
        //main.java.ch03_class.basic.oop.model.vo.Galaxy

        System.out.println("------------------------------------");
        // toString()

        Phone phone = new Phone("아이폰 24", "gold");
        Apple apple = new Apple("아이폰 XS", "gray", "3버전");

        System.out.println(phone.toString());
        System.out.println(apple);
        // Print 수행 시 참조 변수명만 작성하는 경우
        // 자동으로 toString 메서드 호출해서 출력함

    }

    public void ex3() {
        Galaxy g = new Galaxy();
    }
}
