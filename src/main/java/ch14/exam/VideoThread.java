package main.java.ch14.exam;

public class VideoThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i<3; i++){
            try{
                System.out.println("동영상을 재생합니다");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
