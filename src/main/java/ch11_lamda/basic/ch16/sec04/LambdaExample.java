package main.java.ch11_lamda.basic.ch16.sec04;

public class LambdaExample {

    public static void main(String[] args) {

        Person p = new Person();

        // 실행문이 두 개 이상인 경우 중괄호 필수, return 생략 불가
        p.action((x, y) -> {
            double result = x + y;
            return result;
        });

        // 실행문이 한 줄인 경우 중괄호와 return 생략 가능
        p.action((x, y) -> x + y);

        // 기존 메서드를 호출하는 람다식
        p.action((x, y) -> sum(x, y));
                                        // sum(x, y) 호출

    }

    public static double sum(double x, double y) {
        return x + y;
        // sum 메서드를 호출한 곳으로 x+y 반환
    }
}
