package main.java.ch08_multithread.thread.ex1;

public class ThreadRun {
    public static void main(String[] args) {
        // main 메서드 실행 시
        // stack 영역에 main thread가 생성되며
        // 해당 스레드에 main() 메서드가 올라가게 된다.

        // Thread.currentThread() : 현재 실행중인 스레드를 반환
        // Thread.currentThread().getName() : 현재 실행중인 스레드의 이름 반환
        System.out.println(Thread.currentThread().getName());

        // 추가 스레드 생성

        // 방법 1. Thread 클래스 상속
        FirstThread thread1 = new FirstThread(); // 객체 생성
        thread1.start(); // 스레드 실행

        // 방법 2. Runnable 인터페이스 상속
        // new Thread(Runnable target)
        // -> Runnable 인터페이스를 상속 받은 객체를 매개변수에 추가
        Thread thread2 = new Thread(new SecondThread());
        thread2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main 스레드 " + i);
        }
    }
}
