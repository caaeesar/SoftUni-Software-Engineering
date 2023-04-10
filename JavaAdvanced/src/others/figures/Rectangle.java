package others.figures;

public class Rectangle extends Shape {

    public Rectangle(int width, int height) {
        super(width, height);
    }

    @Override
    public int calculateSurface() {
        return this.width * this.height;
    }
}
