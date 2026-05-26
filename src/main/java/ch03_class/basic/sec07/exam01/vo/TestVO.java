package main.java.ch03_class.basic.sec07.exam01.vo;
// VO(Value Object) : 값 저장용 객체를 만들기 위한 클래스를 모아두는 패키지
class TestVO {
    // 접근제한자 (default) : 같은 패키지 내에서만 import 가능

    public void ex() {
        System.out.println("같은 패키지");

        // 학생 개체 생성
        Student st = new Student();
        System.out.println(st.v1);
        System.out.println(st.v2);
        System.out.println(st.v3);
//        System.out.println(st.v4);
        // v4는 private이기 깨문에 같은 패키지여도 다른 클래스에서 직접 접근 불가
    }
}
