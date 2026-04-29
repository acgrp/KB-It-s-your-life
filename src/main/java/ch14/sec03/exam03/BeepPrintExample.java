package main.java.ch14.sec03.exam03;

public class BeepPrintExample {

    public static void main(String[] args) {

        Thread thread = new Thread() {

            @Override
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    System.out.println("비프음");
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread.start();
        for (int i = 0; i<=10; i++){
            try {
                System.out.println("띵");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
