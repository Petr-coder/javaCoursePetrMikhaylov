package day9.Task2;

public class Triangle extends Figure {
    private double side1;
    private double side2;
    private double side3;

    public double getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(int side3) {
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3, String color) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        double halfPeriod = perimeter() / 2;
        return Math.sqrt(halfPeriod * (halfPeriod - side1) * (halfPeriod - side2) * (halfPeriod - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }
}
