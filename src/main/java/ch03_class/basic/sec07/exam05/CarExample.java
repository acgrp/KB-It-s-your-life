package main.java.ch03_class.basic.sec07.exam05;

public class CarExample {
    public static void main(String[] args) {

        Car c1 = new Car();
        System.out.println(c1.company);
        System.out.println();

        Car c2 = new Car("자가용");
        System.out.println(c2.company);
        System.out.println(c2.model);
        System.out.println();

        Car c3 = new Car("자가용", "빨강");
        System.out.println(c3.company);
        System.out.println(c3.model);
        System.out.println(c3.color);
        System.out.println();

        Car c4 = new Car("택시", "검정", 200);
        System.out.println(c4.company);
        System.out.println(c4.model);
        System.out.println(c4.color);
        System.out.println(c4.maxSpeed);
    }
}
