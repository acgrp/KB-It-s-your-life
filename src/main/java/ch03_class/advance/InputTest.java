package main.java.ch03_class.advance;

public class InputTest {
    public static void main(String[] args) {

        //이름 입력 받기
        String name = Input.read("이름: ");
        System.out.println("입력값: " + name);

        // 이름(기본값) 입력 받기
        String defaultName = Input.read("이름(홍길동): ", "홍길동");
        System.out.println("입력값: " + defaultName);

        // 나이 입력 받기
        int age = Input.readInt("나이: ");
        System.out.println("입력값: " + age);

        // 종료 여부 Confirm 요청
        boolean exit = Input.confirm("종료할까요? (Y/n): ", false);
        System.out.println("입력값: " + exit);

        // 기본값을 true로 설정하여 종료 여부 Confirm 요청
        exit = Input.confirm("종료할까요? (Y/n): ");
        System.out.println("입력값: " + exit);

    }
}
