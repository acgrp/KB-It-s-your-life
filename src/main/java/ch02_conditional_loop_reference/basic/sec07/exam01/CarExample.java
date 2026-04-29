package main.java.ch02_conditional_loop_reference.basic.sec07.exam01;

public class CarExample {

    public static void main(String[] args) {
        Car myCar = new Car("그랜저", "검정", 250);

        // myCar 객체 필드값 출력
        // 값이 안담긴 이유 : Car 필드에 초기화하지 않았기 때문에
        System.out.println("=============================");
        System.out.println("myCar = " + myCar.model);
        System.out.println("myCar = " + myCar.color);
        System.out.println("myCar = " + myCar.maxSpeed);
    }
}
