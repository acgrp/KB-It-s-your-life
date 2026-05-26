package main.java.ch03_class.basic.sec08.exam02;

public class Computer {
    public int sum(int i1, int i2, int i3) {
        return i1 + i2 + i3;
    }

    public int sum(int i, int i1, int i2, int i3, int i4) {
        return i+i1+i2+i3+i4;
    }

    public int sum(int[] values) {
        int num = 0;
        for (int i = 1; i < 6; i++) {
            num += i;
        }
        return num;
    }

}
