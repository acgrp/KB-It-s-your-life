package main.java.ch02_conditional_loop_reference.basic.sec07.exam01;

public class Car {
    // 속성(== 필드)
    String model;
    String color;
    int maxSpeed;


    // 기능(== 생성자 + 메서드)


    // 기본 생성자
    public Car() {
        System.out.println("기본 생성자로 Car 객체 생성");
    }

    // 매개변수 생성자
    public Car(String model){
        System.out.println("매개변수 1개 생성자");
    }

    public Car(String model, String color){
        System.out.println("매개변수 2개 생성자");
    }
    public Car(String model, String color, int maxSpeed){
        System.out.println("매개변수 3개 생성자");
        System.out.println("model = " + model);
        System.out.println("color = " + color);
        System.out.println("maxSpeed = " + maxSpeed);

        // 전달 받은 값을 필드에 초기화
        // - 객체가 자기 자신을 참조할 수 있도록 하는 변수
        // - 모든 객체 내부에 숨겨져 있다.

        // 사용 이유??
        // -> 필드명과 매개변수명이 같을 경우
        //    이를 구분하기 위해서 주로 사용함

        // ** this 참조 변수 **
        this.model = model;
        //필드 = 매개변수
        // 현재 객체가 가지고 있는 필드 model(this.model)에
        // 매개변수 model 값을 대입
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
