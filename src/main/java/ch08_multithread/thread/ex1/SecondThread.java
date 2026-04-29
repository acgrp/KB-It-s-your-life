package main.java.ch08_multithread.thread.ex1;

// 스레드 생성 방법 2 : Runnable 인터페이스 상속
// Runnable 인터페이스 : 스레드가 실행할 작업(run)을 정의하는 미완성된 설계도
public class SecondThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "실행");

        for (int i = 0; i < 10; i++) {
            System.out.println("1번 스레드 " + i);
        }
    }
}
