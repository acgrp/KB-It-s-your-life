package main.java.ch03_class.basic.sec07.exam01.vo;

public class People {

    // 클래스란? 객체를 만들기 위한 설계도
    // -> 객체의 특성(속성, 기능)을 정의한 것

    // 캡슐화(Encapsulation)
    // - 데이터와 기능을 하나로 묶어서 관리하는 기법
    // - 데이터의 직접적인 접근을 제한하는 것이 원칙
    // -> 직접 접근을 못하기 때문에 클래스 내부에
    //    간접 접근 방법을 제공하는 기능을 작성해둠

    //  ** 데이터 직접 접근 제한 **
    //  public(공공의) -> private(사적인, 개인적인)

    // 속성 == data == 값
    // 값을 저장하기 위한 변수 선언
    private String name;// 이름
    private char gender;// 성별
    private int age; // 나이
//    private double bitCoin; // -> 공통점이 아니므로 제거(추상화)

    // 기능 == method == 행동

    // 생성자

    public People(String name) {
        this.name = name;
    }


    // 기본 생성자

    public People() {}

    // 매개변수 3개 생성자

    public People(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void tax() {
        System.out.println("세금을 납부한다.");
    }

    // getter / setter

    public String getName() {
        // 현재 객체의 속성 중 name을 호출한 곳으로 반환
        return name;  // (== this.name)
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }


}
