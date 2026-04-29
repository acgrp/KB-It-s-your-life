package main.java.ch03_class.basic.ch07.sec04.exam01;

public class ComputerExample {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        System.out.println(calculator.areaCircle(100));

        Computer computer = new Computer();
        System.out.println(computer.areaCircle(10));

    }
}
