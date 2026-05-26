package main.java.ch11_lamda.basic.ch16.sec02.exam01;

import static main.java.ch11_lamda.basic.ch16.sec01.LambdaExample.action;

public class LambdaExample {

    public static void main(String[] args) {

        Person person = new Person();

        person.action(new Workable() {
            @Override
            public void work() {
                System.out.println("출근 합니다.");
                System.out.println("야근 합니다...");
            }
        });
        // 람다식으로 변경하기
        // 실행문이 두 개 이상인 경우 중괄호 필수
        person.action(() -> {
            System.out.println("출근 합니다.");
            System.out.println("야근 합니다...");
        });

        // 실행문이 한 개일 경우 중괄호 생략 가능
        person.action(() -> System.out.println("퇴근 합니다."));
    }

}
