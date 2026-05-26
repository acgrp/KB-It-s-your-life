package main.java.ch11_lamda.basic.ch16.sec03;

public class Person {

    // Workable 인터페이스를 매개변수로 받음
    // -> 어떤 일(work)을 할지 외부에서 전달받는 구조
    public void action1(Workable workable) {

        // 전달 받은 작업 실행
        workable.work("홍길동", "프로그래밍");
    }

    public void action2(Speakable speakable) {
        speakable.speak("안녕하세요");
    }
}
