package main.java.ch05_abstract_interface.oop.model.service;
// 계산기 인터페이스
// -> 모든 계산기가 공통적으로 가져야할 기능(메서드)을 정의하는 규칙
public interface Calculator {
    // 인터페이스 : 클래스가 반드시 지켜야하는 규칙(메서드 목록)을 정의하는 설계도
    // 추상클래스 : 공통된 기능을 제공하면서, 필요 시 추상 메서드로 확장을 강제하는 클래스

    // 필드(묵시적으로 public static final)
    public static final double PI = 3.14;
    static final int MAX_NUM = 2_147_000_000;
    public int MIN_NUM = -2_147_000_000;
    int ZERO = 0;

    // 메서드 (묵시적으로 public abstract)

    public abstract int plus(int num1, int num2);
    abstract int minus(int num1, int num2);
    int multiple(int num1, int num2);
    public int divide(int num1, int num2);

}
