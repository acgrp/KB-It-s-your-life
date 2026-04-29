package main.java.ch05_abstract_interface.oop.model.vo;

public class Fish extends Animal{
    // Animal의 추상 메서드를 오버라이딩 하지않으면 오류 발생
    @Override
    public void eat() {
        System.out.println("뻐끔뻐끔 거리면서 먹는다");
    }

    @Override
    public void breath() {
        System.out.println("아가미로 호흡한다.");
    }
}
