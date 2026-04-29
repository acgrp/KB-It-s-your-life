package main.java.ch03_class.basic.sec14;

public class Car {

    private int speed;
    private boolean stop;

    public Car(int speed, boolean stop) {
        this.speed = speed;
        this.stop = stop;
    }

    public int getSpeed() {
        System.out.println("현재 속도 : " + speed);
        return speed;
    }

    public boolean isStop() {
        System.out.println(stop);
        return stop;
    }

    public void setSpeed(int speed) {
        if (speed < 0){
            this.speed = 0;
            System.out.println("현재 속도 : " + this.speed);

        }else{
            this.speed = speed;
            System.out.println("현재 속도 : " + this.speed);
        }
    }

    public void setStop(boolean stop) {
        if (stop){
            this.speed = 0;
        }
        this.stop = stop;
    }
}
