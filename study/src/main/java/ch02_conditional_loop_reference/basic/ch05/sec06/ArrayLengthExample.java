package main.java.ch02_conditional_loop_reference.basic.ch05.sec06;

public class ArrayLengthExample {
    public static void main(String[] args) {

        int[] arr = new int[3];

        int sum = 0;

        arr[0] = 84;
        arr[1] = 90;
        arr[2] = 96;

        for (int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        double avg = (double)sum/arr.length;

        System.out.println("합계 : " +sum);
        System.out.println("평균 : " +avg);
    }
}
