package main.java.ch05_abstract_interface.oop.model.service;

import main.java.ch05_abstract_interface.oop.model.vo.Person;

public class AbstractService {

    public void ex1() {
        // 추상 클래스를 객체로 만들 수 있을까?

//        Animal animal = new Animal();
        // 'Animal' is abstract; cannot be instantiated
        // - 객체화 할 수 없다.

        // 클래스 : 객체의 속성(필드)과 기능(메서드)을 정의한 것(설계도)
        // 추상 클래스 : 미완성된 메서드를 포함한 클래스 (미완성 설계도)
        // -> 미완성된 설계도로 객체를 만들 수 없다!

        // 해결 방법 : Animal을 상속 받아
        //            미완성 부분을 구현한 클래스를 이용하여 객체 생성

        // * 추상 클래스를 상속 받은 자식 객체 생성
        Person p1 = new Person();

        p1.setName("홍길동");

        // 상속 받은 기능 호출
        p1.setType("척추동물");
        p1.setEatType("잡식");

        // 오버라이딩한 메서드 호출
        p1.eat();
        p1.breath();
    }
}
