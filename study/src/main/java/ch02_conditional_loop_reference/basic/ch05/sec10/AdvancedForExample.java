package main.java.ch02_conditional_loop_reference.basic.ch05.sec10;

public class AdvancedForExample {
    public static void main(String[] args) {
        int[] scores = {95, 71, 84, 93, 87};

        int sum = 0;

        for (int x : scores){
            sum += x;
            System.out.println(x);
        }
        double avg = (double)sum/scores.length;

        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);
    }


}
