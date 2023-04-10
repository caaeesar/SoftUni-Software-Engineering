package StreamsFilesDirectories.lab.SerializeCustomObject;

public class Cube {
    private String color;
    private double width;
    private double height;
    private double depth;

    Cube(String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public String getColor() {
        return color;
    }
}
