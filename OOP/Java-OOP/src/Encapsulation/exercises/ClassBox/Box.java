package Encapsulation.exercises.ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        validateSide(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateSide(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateSide(height, "Height");
        this.height = height;
    }

    private void validateSide(double value, String side) {
        if (value <= 0) {
            throw new IllegalArgumentException(side + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        // Surface Area = 2lw + 2lh + 2wh
        return (2 * this.length * this.width) +
                (2 * this.length * this.height) +
                (2 * this.width * this.height);
    }

    public double calculateLateralSurfaceArea() {
        // Lateral Surface Area = 2lh + 2wh
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateVolume() {
        // Volume = lwh
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Surface Area - %.2f", this.calculateSurfaceArea())).append(System.lineSeparator());
        output.append(String.format("Lateral Surface Area - %.2f", this.calculateLateralSurfaceArea())).append(System.lineSeparator());
        output.append(String.format("Volume – %.2f", this.calculateVolume()));
        return output.toString();
    }
}
