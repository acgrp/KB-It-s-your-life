package main.java.ch03_class.basic.oop.run;

import main.java.ch03_class.basic.oop.model.service.InheritanceService;

public class InheritanceRun {
    public static void main(String[] args) {

        InheritanceService service = new InheritanceService();

//        service.ex1(); // 상속 확인 예제
//        service.ex2(); // 오버라이딩 확인 예제
        service.ex3();
    }
}
