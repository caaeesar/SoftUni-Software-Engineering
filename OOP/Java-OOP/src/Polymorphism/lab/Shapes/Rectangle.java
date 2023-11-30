package Polymorphism.lab.Shapes;

public class Rectangle extends Shape {

    public static final int CONSTANT = 2;
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
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
        return CONSTANT * (this.width + this.height);
    }

    @Override
    public Double calculateArea() {
        return this.height * this.width;
    }
}
