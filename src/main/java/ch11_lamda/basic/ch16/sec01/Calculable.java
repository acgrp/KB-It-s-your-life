package main.java.ch11_lamda.basic.ch16.sec01;

// 함수형 인터페이스 선언
// "추상 메서드가 딱 1개만 있는 인터페이스"라는 걸 보장해주는 어노테이션
// 만약 추상 메서드를 2개 이상 만들면 컴파일 에러 발생

@FunctionalInterface
public interface Calculable {

    // 추상 메서드
    void calculate(int x, int y);

//    void calculate2(int x, int y); // 에러 발생



}
