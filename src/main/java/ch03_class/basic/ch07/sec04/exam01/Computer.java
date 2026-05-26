package main.java.ch03_class.basic.ch07.sec04.exam01;

public class Computer extends Calculator{

    public double areaCircle(double r) {
        System.out.println("CCCalculator 객체의areaCircle() 실행");
        return 3.14159 * r * r;
    }
}
