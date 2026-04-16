package main.java.ch01_variable_type_operator.basic.ch01.sec11;

public class Calculator {

    public static void main(String[] args) {
        /*
        변수 : 값을 기록하고 사용하기 위한 메모리 공간,
        값을 보관하거나, 보관된 값을 가져와 사용할 수 있다.

        변수 선언 : 메모리에 값을 저장할 공간을 할당하는 것
        변수 값 대입(집어넣기) : 변수에 값을 집어 넣는 것

        [표현법]
        자료형 변수이름;

        자료형 : 변수의 크기및 모양을 지정해주는 부분
        변수이름 : 변수를 식별하기위해 붙여주는 이름

        * 자바 기본 자료형 8가지
        논리형 : boolean(1byte)
        정수형 : byte(1byte), short(2byte), *int(4byte), long(8byte)
        실수형 : float(4byte), *double(8byte)
        문자형 : char(2byte, 유니코드)
         */

        int x = 1; // 변수 x를 선언하고 1을 대입
        int y = 2; // (정수형) 변수 y를 선언하고 2를 대입
        int result = x + y; // 변수 result를 선언하고 x+y값을 대입
        System.out.println("result값 : " + result);


    }
}
