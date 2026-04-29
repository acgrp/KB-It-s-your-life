package main.java.ch04_Inheritance_polymorphism.bonus.practice.point.controller;

import main.java.ch04_Inheritance_polymorphism.bonus.practice.point.model.vo.Circle;

public class CircleController {
    private Circle c = new Circle();

    public void calcArea(int x, int y, int radius){
        c = new Circle(x, y, radius);
        c.getX();
        c.getY();
        c.getRadius();
        System.out.println(" 면적 : " + Math.PI*radius*radius);
    }

    public void calcCircum(int x, int y, int radius) {
        c = new Circle(x, y, radius);
        c.getX();
        c.getY();
        c.getRadius();
        System.out.println(" 둘레 : " + Math.PI*radius*2);
    }

}
