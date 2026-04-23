package main.java.ch05_abstract_interface.oop.model.service;

public class KMGCalculator implements Calculator {
    // extends : 확장하다 / implements : 구현하다
    // (부) 클래스      - (자) 클래스 상속 시      : extends
    // (부) 인터페이스   - (자) 클래스 상속 시      : implements
    // (부) 인터페이스   - (자) 인터페이스 상속 시   : extends

    // 메서드 (오버라이드)
    @Override
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiple(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        return num1 / num2;
    }
}
