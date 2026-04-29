package main.java.ch03_class.basic.ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
//        Parent parent = child;
        // child를 부모타입으로 업캐스팅 하는것 (하게 되면 method3못씀)
        child.method1();
        child.method2();
        child.method3();
    }
}
