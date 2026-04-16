package main.java.ch02_conditional_loop_reference.advance;

import java.util.Scanner;

public class ad6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = 0;
        int bank = 0;
        int money = 0;

        while(num != 4){
            System.out.println("----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("----------------------------------");
            System.out.print("선택> ");
            num =  scanner.nextInt();

            if (num == 1){
                System.out.print("예금액> ");
                bank += scanner.nextInt();
            }
            if (num == 2){
                System.out.print("출금액> ");
                bank -= scanner.nextInt();
            }
            if (num == 3){
                System.out.println("잔고> " + bank);
            }
            if (num == 4){
                System.out.println("프로그램 종료");
                break;
            }
        };


    }
}
