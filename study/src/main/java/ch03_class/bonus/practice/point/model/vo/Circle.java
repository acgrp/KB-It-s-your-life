package main.java.ch03_class.bonus.practice.point.model.vo;

public class Circle extends Point{
    private int radius;

    public Circle() {
    }

    public Circle(int x, int y, int radius) {
        setX(x);
        setY(y);
        this.radius = radius;

    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "X : " + getX() + "Y : " + getY() + " radius : " + radius;
    }
}
