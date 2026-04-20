package main.java.ch03_class.basic.sec07.exam01.run;

import main.java.ch03_class.basic.sec07.exam01.service.ClsService;
import main.java.ch03_class.basic.sec07.exam01.vo.Student;

public class ClaRun {
    public static void main(String[] args) {
        Student st = new Student();
//        st.ex();

        ClsService service = new ClsService();
        // service.ex1(); // 접근 제한자 예제 확인
//        service.ex2(); // static 예제 확인
        service.ex3(); // static 예제 확인
    }
}
