package main.java.ch02_conditional_loop_reference.basic.ch06.sec01;

import java.util.Scanner;

public class ArrayExample2 { // 예제 작성용 클래스

    public void ex1() {
        // 배열 선언 및 할당
        int[] arr = new int[4];

        // 1) stack 영역에 int[] 자료형 arr 선언
        // 2) heap영역에 int 자료형 4개를 묶음으로 다루는 int[] 할당
        // 3) heap 영역에서 생성된 int[]의 시작 주소를
        // arr에 대입하여 참조하는 형태를 만든다.

        // 배열의 길이 : 배열명.length
        System.out.println("배열의 길이 : " + arr.length);

        // 배열에 값 대입하기
        // 1. 일반 for문
        for (int i = 0; i < arr.length; i++){
            arr[i] = 100;
            System.out.printf("arr[%d] : %d\n", i, arr[i]);
        }

        int num = 0;
        // 2. 향상된 for문으로 값 출력하기
        for(int a : arr) {

            System.out.printf("arr[%d] : %d\n", num, a);
            num++;
        }
    }

    public void ex2() {
        // 숙제
        // 입력 받은 양의 정수 만큼의
        // 크기를 가지는 배열 만들기

        // [평균 점수 구하기]
        // 입력 받을 인원 수 : 4
        // 1번 점수 입력 : 100
        // 2번 점수 입력 : 20
        // 3번 점수 입력 : 50
        // 4번 점수 입력 : 90

        // 합계 : 260 점
        // 평균 : 65 점
        //-----------------------------------
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        double averAge = 0;

        System.out.print("입력 받을 인원 수 : ");
        int num = scanner.nextInt();
        int [] arr = new int [num];

        for (int i = 0; i < num; i++){
            System.out.print((i+1) + "번 점수 입력 : ");
            int arrNum = scanner.nextInt();
            arr[i] = arrNum;
            sum += arrNum;
        }
        averAge = sum/num;
        System.out.println("합계 : " + sum);
        System.out.println("평균 : " + averAge);

    }
}
