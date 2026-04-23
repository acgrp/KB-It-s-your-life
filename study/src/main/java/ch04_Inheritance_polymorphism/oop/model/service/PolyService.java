package main.java.ch04_Inheritance_polymorphism.oop.model.service;

import main.java.ch04_Inheritance_polymorphism.oop.model.vo.Apple;
import main.java.ch04_Inheritance_polymorphism.oop.model.vo.Galaxy;
import main.java.ch04_Inheritance_polymorphism.oop.model.vo.Phone;

public class PolyService {
    public void ex1() {
        // 다형성 확인 예제

        //Phone 객체 생성
        Phone phone = new Phone();
//    부모타입 참조변수 = 부모객체

        //Apple 객체 생성
        Apple apple = new Apple();
//    자식타입 참조변수 = 자식객체

        // ****** 다형성 (업캐스팅) ******
        Phone phone2 = new Apple();
        //부모타입 참조변수 = 자식객체
        // -> 오류 발생 안함!
        // 왜? Apple 객체를 참조하는 변수(phone2)의 타입이
        // 부모이기 때문에 Apple 객체가 Phone 객체로 변화함

        Phone phone3 = new Galaxy();

        // 1) 자식객체가 부모 객체로 변했기 때문에
        //    자식만의 고유한 필드, 메소드 사용 불가

        // 1-1) phone(부모 = 부모)
        phone.setModel("샤오미");
        phone.setColor("white");
        // Phone 메소드 전부 사용 가능

        // 1-2) apple(자식 = 자식)
        apple.setIosVersion("12.4");
        // Apple 메서드 사용 가능

        // 1-3) phone2(부모 = 자식(Apple))
//        phone2.setIosVersion("10");
        // -> 오류 발생

        // ------------------------------------------------

        // 2) 다형성을 이용한 객체 배열

        // 객체 배열 : 같은 참조 자료형의 변수를 묶음으로 다루는 것
        // -> 각 요소 하나가 참조 변수

        // * 다형성 적용
        // -> 부모 타입 참조변수를 묶음으로 다루는 것

        // ** 다형성 : 부모타입 참조변수로 자식객체를 참조하는 것 **

        Phone[] arr = new Phone[3];
        // 부모타입 참조변수(arr)에 배열 선언 및 할당
        // 각 배열 요소가 Phone 타입 참조 변수

        arr[0] = phone; // Phone 주소 == Phone 객체
    // 부모타입 = 부모객체
        arr[1] = phone2; // Apple 주소 == Apple 객체
        // 부모타입 = 자식객체
        arr[2] = phone3; // Galaxy 주소 == Galaxy 객체
        // 부모타입 = 자식객체

        for (int i = 0; i < arr.length; i++) {
            arr[i].pay();
        }
    }
}
