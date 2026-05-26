package main.java.ch03_class.basic.sec09;

public class Car {

    //필드 선언
    String model;
    int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void run(){
        System.out.printf("%s 가 달립니다.(시속: %d km/h)", model, speed);
        // s : 글자 , d : 숫자
    }

}
