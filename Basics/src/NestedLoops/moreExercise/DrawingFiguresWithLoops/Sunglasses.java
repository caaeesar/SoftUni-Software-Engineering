package NestedLoops.moreExercise.DrawingFiguresWithLoops;

import java.util.Scanner;

public class Sunglasses {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int size = input * 5;
        int parts = (size - input) / 2;
        String midRow = "";

        // първия и последния ред са еднакви
        String star = repeatString("*", parts);
        String space1 = repeatString(" ", input);
        String firstLastRow = star + space1 + star;

        System.out.println(firstLastRow);

        // вътрешните редове
        for (int insideRow = 0; insideRow < input - 2; insideRow++) {

            if (insideRow == (input - 1) / 2 - 1) {
                String slash = repeatString("/", parts - 2);
                String pipe = repeatString("|", input);
                midRow = "*" + slash + "*" + pipe + "*" + slash + "*";
            } else {
                String slash = repeatString("/", parts - 2);
                String space2 = repeatString(" ", input);
                midRow = "*" + slash + "*" + space2 + "*" + slash + "*";
            }
            System.out.println(midRow);
        }
        System.out.println(firstLastRow);
    }

    //метод
    static String repeatString(String str, int count) {
        String text = "";

        for (int i = 1; i <= count; i++) {
            text += str;
        }
        return text;
    }
}


