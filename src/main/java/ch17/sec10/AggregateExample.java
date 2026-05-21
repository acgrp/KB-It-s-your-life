package main.java.ch17.sec10;

import java.util.Arrays;
public class AggregateExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};



        //2의 배수 카운팅
        long count = Arrays.stream(arr).filter(n -> n % 2 == 0).count();
        System.out.println("count = " + count);

        //2의 배수 총합
        long count2 = Arrays.stream(arr).filter(n -> n % 2 == 0).sum();
        System.out.println("count2 = " + count2);

        //2의 배수 평균
        System.out.println("count2/count = " + count2/count);

        //2의 배수 중 최대값
        long count3 = Arrays.stream(arr).filter(n -> n % 2 == 0).max().getAsInt();
        System.out.println(count3);

        //2의 배수 중 최소값
        long count4 = Arrays.stream(arr).filter(n -> n % 2 == 0).min().getAsInt();
        System.out.println(count4);

        //첫 번째 3의 배수
        long count5 = Arrays.stream(arr).filter(n -> n % 3 == 0).findFirst().getAsInt();
        System.out.println(count5);

    }
}