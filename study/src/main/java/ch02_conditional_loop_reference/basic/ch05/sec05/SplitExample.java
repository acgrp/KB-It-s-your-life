package main.java.ch02_conditional_loop_reference.basic.ch05.sec05;

public class SplitExample {
    public static void main(String[] args) {
        String board = "1,자바 학습,참조 타입 String을 학습합니다.,홍길동";
        String[] arr = board.split(",");
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }
}
