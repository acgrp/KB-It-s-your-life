package main.java.ch01_variable_type_operator.basic.ch02.sec08;

public class CastingExample {
    public static void main(String[] args) {
        /* 형변환(Casting)
         * 자료형을 다른 자료형으로 변경해주는 것(단, boolean 제외)
         *
         * 형변환이 필요한 이유
         * : 컴퓨터는 기본적으로 같은 자료형 끼리만 연산 가능
         *
         * [값의 범위]가 큰 자료형과 [값의 범위]가 작은 자료형의 연산 시
         *
         * 자동형변환
         * 값의 범위가 [작은 자료형] -> 값의 범위가 [큰 자료형]으로
         * 컴파일러에 의해서 자동적으로 변환되는 것
         *
         * 명시적형변환(강제형변환)
         * 값의 범위가 [큰 자료형] ->  값의 범위가 [작은 자료형]으로 변환할 때 사용
         * 자동으로 컴파일러가 이를 수행하지 않으므로 프로그래머가 직접 진행한다.(데이터손실 감수)
         * -> 자료형을 변환시키고 싶은 값 또는 변수 앞에 (자료형) 작성
         * */

        // 강제 형변환
        int var1 = 10;
        byte var2 = (byte) var1;
        System.out.println(var2); // 오버플로우

        long var3 = 300;
        int var4 = (int) var3;
        System.out.println(var4);
//        int var5 = 65;
//        char var6 = var5;
//        System.out.println(var6);
//        double var7 = 3.14;
//        int var8 = var7;
//        System.out.println(var8);

        // 자동형변환
        double var9 = 3.141592;
        int var10 = 12345;
        System.out.println(var9 + var10);
        // double + int
        // double + double(12345.0) = double

        System.out.println(10 / 4);
    }
}
