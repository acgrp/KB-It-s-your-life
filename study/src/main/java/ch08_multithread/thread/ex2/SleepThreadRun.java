package main.java.ch08_multithread.thread.ex2;

public class SleepThreadRun {
    public static void main(String[] args) {

        Thread sleepThread = new Thread(new SleepThread());
        sleepThread.start();
        // -> SleepThread의 run() 메서드 실행
        // - 현재 스레드를 지정된 시간만큼 일시정지
        // - 시간은 1/1000초 단위(ms)로 지정
        // - InterruptedException 예외 처리 필요

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            //예외가 발생한 위치와 흐름을 출력
        }


        for (int i = 1; i < 10; i++){
            System.out.println(i + "초");
        }
    }
}
