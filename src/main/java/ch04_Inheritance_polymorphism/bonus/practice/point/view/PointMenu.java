package main.java.ch04_Inheritance_polymorphism.bonus.practice.point.view;

import main.java.ch04_Inheritance_polymorphism.bonus.practice.point.controller.CircleController;
import main.java.ch04_Inheritance_polymorphism.bonus.practice.point.controller.RectangelController;

import java.util.Scanner;

public class PointMenu {

    private Scanner sc = new Scanner(System.in);

    CircleController cc = new CircleController();

    RectangelController rc = new RectangelController();

    public void mainMenu() {

        int menu = 0;
        while (true) {
            System.out.println("========== 메인 메뉴 ==========");
            System.out.println("1. 원");
            System.out.println("2. 사각형");
            System.out.println("9. 끝내기");
            System.out.print("메뉴 번호 : ");
            menu = sc.nextInt();

            if (menu == 1) {
                circleMenu();
            } else if (menu == 2) {
                rectangleMenu();
            }else if (menu == 9) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 돌아갑니다.");
            }
        }
    }

    public void circleMenu() {
        int menu = 0;
        while (true) {
            System.out.println("========== 메인 메뉴 ==========");
            System.out.println("1. 원 둘레");
            System.out.println("2. 원 넓이");
            System.out.println("9. 메인으로");
            System.out.print("메뉴 번호 : ");
            menu = sc.nextInt();
            if (menu == 1) {
                calcCircum();
            } else if (menu == 2) {
                calcCircleArea();
            }else if(menu == 9) {
                mainMenu();
            } else {
                System.out.println("잘못된 입력입니다. 다시 돌아갑니다.");
            }
        }
    }

    public void rectangleMenu() {
        int menu = 0;
        while (true) {
            System.out.println("========== 메인 메뉴 ==========");
            System.out.println("1. 사각형 둘레");
            System.out.println("2. 사각형 넓이");
            System.out.println("3. 메인으로");
            System.out.print("메뉴 번호 : ");
            menu = sc.nextInt();
            if (menu == 1) {
                calcPerimeter();
            } else if (menu == 2) {
                calcRectArea();
            }else if(menu == 3) {
                mainMenu();
            } else {
                System.out.println("잘못된 입력입니다. 다시 돌아갑니다.");
            }
        }
    }

    public void calcCircum() {
        System.out.print("x 좌표 : ");
        int x = sc.nextInt();
        System.out.print("y 좌표 : ");
        int y = sc.nextInt();
        System.out.print("반지름 : ");
        int radius = sc.nextInt();
        cc.calcCircum(x, y, radius);
    }

    public void calcCircleArea() {
        System.out.print("x 좌표 : ");
        int x = sc.nextInt();
        System.out.print("y 좌표 : ");
        int y = sc.nextInt();
        System.out.print("반지름 : ");
        int radius = sc.nextInt();
        cc.calcArea(x, y, radius);
    }

    public void calcPerimeter() {
        System.out.print("x 좌표 : ");
        int x = sc.nextInt();
        System.out.print("y 좌표 : ");
        int y = sc.nextInt();
        System.out.print("높이 : ");
        int h = sc.nextInt();
        System.out.print("너비 : ");
        int w = sc.nextInt();

        rc.calcPerimeter(x,y,h,w);
    }

    public void calcRectArea() {
        System.out.print("x 좌표 : ");
        int x = sc.nextInt();
        System.out.print("y 좌표 : ");
        int y = sc.nextInt();
        System.out.print("높이 : ");
        int h = sc.nextInt();
        System.out.print("너비 : ");
        int w = sc.nextInt();

        rc.calcArea(x,y,h,w);
    }
}

