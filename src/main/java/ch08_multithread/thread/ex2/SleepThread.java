package main.java.ch08_multithread.thread.ex2;

public class SleepThread implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "실행");

        for(int i = 0; i <= 10; i++){
            System.out.println(i + "초");
        }
    }
}
