package main.java.ch03_class.basic.ch07.sec03.exam02;

public class Phone {
    public String model;
    public String color;

    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
        System.out.printf("Phone(%s, %s) 생성자실행", this.model, this.color);
    }
}
