package main.java.ch14.exam;

public class MusicRunnableEx {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MusicRunnable());
        thread1.start();
    }


}
