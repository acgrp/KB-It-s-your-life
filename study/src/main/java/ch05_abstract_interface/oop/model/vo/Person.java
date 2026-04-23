package main.java.ch05_abstract_interface.oop.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person extends Animal {
    // 필드
    private String name;

    // 생성자
    public Person() {
        super(); // == Animal 기본 생성자
        // 생략 시 컴파일러가 추가
    }

    public Person(String name) {
        this.name = name;
    }

    // 메서드
    // 추상 메서드는 상속 받으면 오버라이딩이 강제된다!
    @Override
    public void eat() {
        System.out.println("숟가락, 젓가락을 이용하여 먹는다.");
    }

    @Override
    public void breath() {
        System.out.println("코나 입으로 숨쉰다.");
    }
}
