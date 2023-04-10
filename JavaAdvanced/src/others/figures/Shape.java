package others.figures;

public abstract class Shape {

    int width;
    int height;

    protected Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract int calculateSurface();

}
