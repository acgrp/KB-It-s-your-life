package main.java.ch02_conditional_loop_reference.basic.ch05.sec09;

public class ArrayCopyExample {
    public static void main(String[] args) {
        String[] oldStrArray = { "java", "array", "copy" };

        String[] newSTrArray = new String[5];

        System.arraycopy(oldStrArray, 0, newSTrArray, 0, oldStrArray.length);

        for (int i= 0; i < newSTrArray.length; i++){
            System.out.println(newSTrArray[i]);
        }

    }
}
