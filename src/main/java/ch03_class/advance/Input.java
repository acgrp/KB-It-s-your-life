package main.java.ch03_class.advance;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static String read(String title) {
        System.out.print(title);
        return scanner.nextLine();
    }

    public static String read(String title, String defaultValue) {
        System.out.printf("%s(%s) ", title, defaultValue);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return defaultValue;
        }
        return input;
    }

    public static int readInt(String title) {
        System.out.print(title);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public static boolean confirm(String title, boolean defaultValue) {
        String yN = defaultValue ? "(Y/n)" : "y/N";
        System.out.printf("%s %s: ", title, yN);

        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return defaultValue;
        }
        return input.equalsIgnoreCase("y");
    }
    public static boolean confirm (String title){
        return confirm(title, true);
    }
}
