package main.java.ch03_class.basic.sec07.exam01;

public class CarExample {
    public static void main(String[] args) {

        Car myCar = new Car("그랜저", "검정", 250);

        System.out.println("myCar = " + myCar.model);
        System.out.println("myCar = " + myCar.color);
        System.out.println("myCar = " + myCar.cost);

    }

}
