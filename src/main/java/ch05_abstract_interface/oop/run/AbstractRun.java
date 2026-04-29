package main.java.ch05_abstract_interface.oop.run;

import main.java.ch05_abstract_interface.oop.model.service.AbstractService;
import main.java.ch05_abstract_interface.oop.model.service.Calculator;
import main.java.ch05_abstract_interface.oop.model.service.JJSCalculator;
import main.java.ch05_abstract_interface.oop.model.service.KMGCalculator;

public class AbstractRun {

    public static void main(String[] args) {

        AbstractService service = new AbstractService();

//        service.ex1();

//        ---------------------------------

//        Calculator calculator = new Calculator();
        // 인터페이스 == 미완성된 설계도 == 객체 생성 불가능
        // -> 추상클래스처럼 참조 변수로는 사용 가능

//        Calculator cal = new JJSCalculator();
        Calculator cal = new KMGCalculator();

        // 코드의 큰 수정 없이 객체 생성 코드만 바꾸면
        // 새로운 클래스의 코드를 수행할 수 있다!

        System.out.println("합 : " + cal.plus(20, 15));
        System.out.println("차 : " + cal.minus(20, 15));
        System.out.println("곱 : " + cal.multiple(20, 15));
        System.out.println("몫 : " + cal.divide(20, 15));

        // 인터페이스의 특징
        // 1) 인터페이스를 부모 참조변수로 사용하면
        //    다형성 업캐스팅이 적용되서
        //    상속 받은 모든 클래스를 자식 객체로 참조 가능

        // 2) 자식 클래스에 공통된 메서드 구현을 강제하기 때문에
        //    자식 클래스가 동일한 형태를 가지게 된다.
        // -> 이를 이용하여 공동작업(팀 프로젝트)에
        //    필요한 개발 환경을 조성할 수 있다.
    }
}
