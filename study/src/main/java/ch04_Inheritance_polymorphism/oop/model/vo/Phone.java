package main.java.ch04_Inheritance_polymorphism.oop.model.vo;

public class Phone {
    private String model;
    private String color;

    public Phone() {
        System.out.println("Phone 기본생성자 호출");
    }

    public Phone(String model, String color){
        this.model = model;
        this.color = color;

        System.out.println("매개변수 생성자 실행");
    }


    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // 메서드
    public void pay() {
        System.out.println("결제하기");
    }

    // Object.toString() 메서드 오버라이딩
    // toString() : 객체가 가지고 있는 모든 값(필드)을
    //              하나의 문자열로 반환하는 용도의 메서드

    @Override
    public String toString() {
        return model + "/" + color;
    }
}
