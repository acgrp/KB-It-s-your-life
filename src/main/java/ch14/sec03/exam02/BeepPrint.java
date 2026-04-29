package main.java.ch14.sec03.exam02;

public class BeepPrint implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        for (int i = 1; i <= 10; i++){
            try{
                Thread.sleep(500);
                System.out.println("비프음");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
