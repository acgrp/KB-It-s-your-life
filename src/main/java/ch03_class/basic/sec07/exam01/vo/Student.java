package main.java.ch03_class.basic.sec07.exam01.vo;

public class Student {
    // 속성(== 필드)

    // -------------------------------------------------------------
    //접근제한자 종류

    // + public  	: 같은 패키지 + 다른 패키지 (모두, 어디서든) 접근 가능
    // # protected 	: 같은 패키지 + 다른 패키지 중 상속 관계 클래스에서만 접근 가능
    // ~ (default) 	: 같은 패키지 내부에서만 접근 가능
    // - private 	: 현재 클래스 (정확히는 현재 객체) 내부에서만 접근 가능
    // -------------------------------------------------------------

    // 인스턴스 변수
    public int v1 = 10;
    protected int v2 = 20;
    int v3 = 30;
    private int v4 = 40;

    // 접근제한자 예제
    public void ex() {
        System.out.println("같은 클래스 내부");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }

    // 클래스 변수(== static 변수)
    // -> 필드에 static 예약어가 작성된 변수
    public static String schoolName = "KB대학원";

    public String name;
    //캡슐화 원칙 때문에 private
    // -> 간접 접근 방법 필요 : getter/setter!

    //getter / setter
    //alt + insert -> Getter / Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 기능

    //접근제한자 종류

    // + public  	: 같은 패키지 + 다른 패키지 (모두, 어디서든) 접근 가능
    // # protected 	: 같은 패키지 + 다른 패키지 중 상속 관계 클래스에서만 접근 가능
    // ~ (default) 	: 같은 패키지 내부에서만 접근 가능
    // - private 	: 현재 클래스 (정확히는 현재 객체) 내부에서만 접근 가능
    // -------------------------------------------------------------
}
