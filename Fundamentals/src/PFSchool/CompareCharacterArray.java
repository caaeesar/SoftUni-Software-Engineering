package PFSchool;

import java.util.Scanner;

public class CompareCharacterArray {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] text1 = scanner.nextLine().split(" ");
        String[] text2 = scanner.nextLine().split(" ");
        boolean allIsEqual = true;

        for (int i = 0; i < text1.length; i++) {

                char symbol1 = text1[i].charAt(0);
                char symbol2 = text2[i].charAt(0);

                if (symbol1 != (symbol2)) {
                    allIsEqual = false;
                }
            }
        if (allIsEqual) {
            System.out.println("All elements are equal");
        }
    }
}
