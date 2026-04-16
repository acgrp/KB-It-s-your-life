package main.java.ch02_conditional_loop_reference.advance;

public class ad2 {
    public static void main(String[] args) {

        for (int i = 0; i <= 5; i++) {
            System.out.println();
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
        }

        for (int i = 5; i >= 0; i--) {
            System.out.println();
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
        }

    }
}
