package others.figures;

public class Triangle extends Shape{

    public Triangle(int width, int height) {
        super(width, height);
    }

    @Override
    public int calculateSurface() {
        return (this.width * this.height) / 2;
    }
}
