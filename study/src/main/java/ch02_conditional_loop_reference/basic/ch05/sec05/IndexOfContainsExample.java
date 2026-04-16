package main.java.ch02_conditional_loop_reference.basic.ch05.sec05;

public class IndexOfContainsExample {
    public static void main(String[] args) {
        String subject = "자바 프로그래밍";

        int location = subject.indexOf("프로그래밍");
//        indexOf(문자열) : 문자열을 찾음(위치는 숫자로 표기)
        System.out.println(location);
        String substring = subject.substring(location);
//        substring(시작, 끝) : 범위 잘라내기
//        substring(시작) : 시작부터 문자열 끝까지 자르기
        System.out.println(substring);

        location = subject.indexOf("자바");
        if(location != -1) {
            System.out.println("자바와 관련된 책이군요");
        }else {
            System.out.println("자바와 관련 없는 책이군요.");
        }


    }
}
