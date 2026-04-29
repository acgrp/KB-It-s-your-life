package main.java.ch04_Inheritance_polymorphism.bonus.practice.point.controller;

import main.java.ch04_Inheritance_polymorphism.bonus.practice.point.model.vo.Rectangle;

public class RectangelController {
    private Rectangle r = new Rectangle();

    public void calcArea(int x, int y, int height, int width){
        r = new Rectangle(x, y, height, width);
        r.getX();
        r.getY();
        r.getHeight();
        r.getWidth();
        System.out.println("면적 : " + width*height);

    }

    public void calcPerimeter(int x, int y, int height, int width) {
        r.getX();
        r.getY();
        r.getHeight();
        r.getWidth();
        System.out.println("둘레 : " + 2*(width + height));
    }
}
