package main.java.ch03_class.basic.sec07.exam02;

public class KoreanExample {
    public static void main(String[] args) {
        //Korean 객체 생성
        Korean k1 = new Korean("김자바", "011225-1234567");
        System.out.println("k = " + k1.nation);
        System.out.println("k = " + k1.name);
        System.out.println("k = " + k1.ssn);


        //또 다른 Korean 객체 생성
        Korean k2 = new Korean("김자바", " 930525-0654321");
        System.out.println("k = " + k2.nation);
        System.out.println("k = " + k2.name);
        System.out.println("k = " + k2.ssn);
    }
}
