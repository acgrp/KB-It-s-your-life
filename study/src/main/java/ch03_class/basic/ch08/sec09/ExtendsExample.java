package main.java.ch03_class.basic.ch08.sec09;

public class ExtendsExample {

    public static void main(String[] args) {
        ch08.sec09.InterfaceCImpl impl = new ch08.sec09.InterfaceCImpl();
        ch08.sec09.InterfaceA ia = impl;
        ia.methodA();
        System.out.println();
        InterfaceB ib = impl;
        ib.methodB();
        System.out.println();

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }

}
