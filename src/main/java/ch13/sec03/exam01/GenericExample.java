package main.java.ch13.sec03.exam01;

public class GenericExample {
    // boxing 제너릭 메서드 정의
    public static void main(String[] args) {
        Box<Integer> box1 = boxing(100);
        int intValue = box1.get();
        System.out.println(intValue);
        Box<String> box2 = boxing("홍길동");
        String strValue = box2.get();
        System.out.println(strValue);
    }

    // <T> Box<T>T → T 로 일관성 유지
    // <T> : 타입선언
    // Box <T> : 반환 타입
    // T t : 매개변수 타입
    private static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.set(t);
        return box;
    }
}
