package main.java.ch02_conditional_loop_reference.basic.ch06.sec00;

import java.util.Scanner;

public class ScannerExample2 {
    public static void main(String[] args) {
        /*
		 * 1부터 사용자에게 입력 받은 수까지의 정수들의 합을
		 * for문을 이용하여 출력하세요.

			ex.
			정수를 하나 입력하세요 : 8
			1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
		 */

        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요 : ");
        int num = scanner.nextInt();
        int sum = 0;

//        for (int i = 1; i <= num; i++) {
//            sum += i;
//            if (i < num){
//                System.out.print(i + " + ");
//            } else {
//                System.out.print(i);
//            }
//        }
//        System.out.print(" = " + sum);

        String calc = "";
        for (int i = 1; i <= num; i++){
            sum += i;
            if (i == num){
                calc += i + " = ";
            }else {
                calc += i + " + ";
            }

        }
        System.out.println(calc + sum);
    }
}