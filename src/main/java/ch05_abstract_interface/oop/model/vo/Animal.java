package main.java.ch05_abstract_interface.oop.model.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Animal {
    // 추상 클래스(adstract class)
    // - 미완성 부분(추상 메서드)이 포함된 클래스
    // - 미완성 클래스이므로 단독 객체 생성 불가능!!

    private String type; //  종/과 구분
    private String eatType; //식성(초식, 육식, 잡식)

    // 생성자
    // - 추상 클래스는 new 연산자를 이용해서
    //   직접적인 객체 생성은 불가능하지만
    //   상속 받은 객체 생성 시 내부의 부모 부분이 생성될 때 사용
    //   == super() 생성자

    // 동물의 공통적인 기능 추출(추상화)
    // -> 동물은 콩통적으로 먹고, 숨쉬지만
    //    어떤 동물이냐에 따라서 방법이 다름
    // -> 해당 클래스에서 메서드를 정의할 수 없다
    public abstract void eat();

    public abstract void breath();

}
