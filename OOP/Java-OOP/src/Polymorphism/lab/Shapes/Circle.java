package Polymorphism.lab.Shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double getPerimeter() {
        return this.calculatePerimeter();
    }

    @Override
    public Double getArea() {
        return this.calculateArea();
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * this.radius;
    }
}
