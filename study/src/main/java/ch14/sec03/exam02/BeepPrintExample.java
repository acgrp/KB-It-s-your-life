package main.java.ch14.sec03.exam02;

public class BeepPrintExample {
    public static void main(String[] args) {


        Runnable task = new BeepPrint();

        Thread sleepThread = new Thread(task);

        sleepThread.start();
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println("띵");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}