package main.java.ch14.exam;

public class VideoThreadEx {
    public static void main(String[] args) {

        Thread thread = new Thread(new VideoThread());
        Thread thread2 = new Thread(new VideoThread());
        Thread thread3 = new Thread(new VideoThread());
        thread.start();
        thread2.start();
        thread3.start();

    }
}
