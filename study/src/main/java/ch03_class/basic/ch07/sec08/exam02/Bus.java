package ch07.sec08.exam02;

import ch08.sec10.exam02.Vehicle;

public class Bus implements Vehicle {

    @Override
    public void run() {
        System.out.println("버스가 달립니다.");
    }

}
