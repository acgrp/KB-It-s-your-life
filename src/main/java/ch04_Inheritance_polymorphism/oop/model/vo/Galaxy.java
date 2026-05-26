package main.java.ch04_Inheritance_polymorphism.oop.model.vo;

public class Galaxy extends Phone{

    private boolean foldable;

    // alt + insert -> constructor
    public Galaxy() {
        // Galaxy 객체 생성 시
        // 내부에 상속 받은 Phone 객체를 생성하기 위한
        // Phone 생성자 호출 코드가 필요!!

        // super == Phone
        super(); // super() 생성자
        // * super() 미작성 시 컴파일러가 자동으로 추가

        System.out.println("Galaxy 기본 생성자 호출");
    }

    public Galaxy(String model, String color, boolean foldable) {
        super(model, color);
        this.foldable = foldable;

        System.out.println("Galaxy 생성자 실행");
    }

    // alt + insert -> getter and setter
    public boolean isFoldable() {
        return foldable;
    }

    public void setFoldable(boolean foldable) {
        this.foldable = foldable;
    }

    // Phone으로부터 상속 받은 메서드 중
    // pay() 메서드를 Galaxy에 맞게 재정의(== 오버라이딩)

    //@Override 어노테이션
    // : 해당 메서드가 오버라이딩 되었음을 알려주는 역할

    // 어노테이션(Annotation) : 컴파일러에게 알려주긴 위한 코드
    @Override
    public void pay() {
        System.out.println("부모로부터 물려받은 메서드 재정의");
        System.out.println("삼성 페이로 결제하기");
    }

}
