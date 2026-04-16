package main.java.ch01_variable_type_operator.basic.ch02.sec06;

public class StringExample {
    public static void main(String[] args) {
        // escape 문자 : 일반 문자가 아닌 특수 문자 표현
        // 문자열 내에서 탭, 백슬레쉬, 작은 따옴표 등을
        // 코드로 사용하기 위한 방식

        System.out.println("a\tb\tc"); // tab 출력
        System.out.println("\\"); // 백슬레쉬 출력
        System.out.println("\""); //쌍따옴표 단순 문자 출력
        System.out.println('\''); //홑따옴표 단순 문자 출력
        System.out.println("\n");// 개행 문자 출력
        System.out.println("\u0041");// 유니코드(16진수)번호로 출력

        // 문자형과 문자열
        // 문자형(char)   : 한글자, 표기법은 ''
        // 문자열(String) : 한글자 이상, 표기법은 ""

    }
}
