package NestedLoops.moreExercise.DrawingFiguresWithLoops;

public class RectangleOf10x10Stars {
    public static void main(String[] arguments) {

        for (int row = 1; row <= 10; row++) {
            for (int colum = 1; colum <= 10; colum++) {

                System.out.print("*");
            }
            System.out.println();
        }
    }
}
