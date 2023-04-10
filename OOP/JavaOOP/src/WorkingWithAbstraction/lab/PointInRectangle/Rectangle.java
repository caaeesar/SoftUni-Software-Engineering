package WorkingWithAbstraction.lab.PointInRectangle;

public class Rectangle {
    private Point bottomLeft; // x1;y1
    private Point topRight; // x2;y2

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point){
        // за да е вътрешна точката:
        // x трябва да е между x1 и x2;
        // y трябва да е между y1 и y2;
        boolean isXInside = point.getX() >= this.bottomLeft.getX() && point.getX() <= this.topRight.getX();
        boolean isYInside = point.getY() >= this.bottomLeft.getY() && point.getY() <= this.topRight.getY();

        return isXInside && isYInside;
    }

}
