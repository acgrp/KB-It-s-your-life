package main.java.ch02_conditional_loop_reference.basic.ch05.sec05;

public class LengthExample {
    public static void main(String[] args) {
        String ssn = "9506241230123";

        if (ssn.length() == 13){
            System.out.println("주민등록번호 자릿수가 맞습니다.");
        } else {
            System.out.println("주민번호 자릿수가 일치하지 않습니다.");
        }

    }
}
