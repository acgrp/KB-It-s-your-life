package main.java.ch01_variable_type_operator.basic.ch04.sec04;

public class SumFrom1To100Example {
    public static void main(String[] args) {

        int sum = 0;
        int i = 1;


        while(i <= 100) {
            sum += i;
            i++;
        }
        System.out.println("1~100의 합 : " + sum);


        int sum2 = 0;
        for (int i2 = 1; i2 <= 100; i2++){
            sum2 += i2;
        }
        System.out.println("1~100 합 : " + sum2);
    }
}
