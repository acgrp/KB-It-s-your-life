package main.java.ch03_class.basic.sec08.exam03;

public class CarExample {
    public static void main(String[] args) {

        Car c1 = new Car();
        c1.setGas(6);
        c1.isLeftGas();
        System.out.println("출발합니다.");
        c1.run();
        System.out.println("gas를 주입하세요.");

    }
}
