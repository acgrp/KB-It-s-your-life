package main.java.ch01_variable_type_operator.basic.ch02.sec01;

public class VariableUseExample {
    public static void main(String[] args) {
        // System.out.printf("포멧", 값)
        // : 출력될 문자열 형식을 패턴으로 지정하는 출력구문
        /* 포멧안에서 쓸 수 있는 키워드
         * %d : 정수
         * %c : 문자(한글자)
         * %s : 문자열
         * %f : 실수
         * */

        int hour = 3;
        int minute = 5;


        // 숫자 + 숫자 = 연산 결과
        System.out.println(hour + minute);

        // 숫자 + 문자열 = 이어쓰기
        System.out.println(hour + "시간 " + minute + "분"); // 3시간 5분
        System.out.printf("%d시간 %d분\n", hour, minute);
        // \n : 개행 문자 (줄바꿈)
        System.out.println("3시간 " + "5분");

        int totalMinute = hour * 60 + minute;

        // 총 185분
        System.out.println("총 " + totalMinute + "분");
        System.out.printf("총 %d분", totalMinute);
    }
}
