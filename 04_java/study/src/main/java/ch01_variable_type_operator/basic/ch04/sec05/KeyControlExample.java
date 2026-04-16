package main.java.ch01_variable_type_operator.basic.ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int speed = 1;
        String num = "";

        while(!num.equals("3")) {
            System.out.println("-----------------------------");
            System.out.println("1. 증속 | 2. 감속 | 3. 중지");
            System.out.println("-----------------------------");
            num = scanner.nextLine();

            if (num.equals("1")) {
                speed++;
                System.out.println("현재속도 : " + speed);
            }else if (num.equals("2")){
                speed--;
                System.out.println("현재속도 : " + speed);
            }else if (num.equals("3")) {
                System.out.println("프로그램 종료");
                System.out.println("최종 속도 : " + speed);
                break;
            }else {
                System.out.println("잘못된 입력");
            }
        }
    }
}
