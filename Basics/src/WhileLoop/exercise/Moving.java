package WhileLoop.exercise;

import java.util.Scanner;

public class Moving {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int freeSpace = width * length * height;
        String input = scanner.nextLine();
        int occupiedPlace = 0;
        int needSpace = 0;
        boolean isHave = true;

        while (!input.equals("Done")) {

            int currentBoxes = Integer.parseInt(input);
            occupiedPlace += currentBoxes;

            if (freeSpace < occupiedPlace) {

                isHave = false;
                needSpace = Math.abs(freeSpace - occupiedPlace);
                break;
            }
            input = scanner.nextLine();
        }

        if (!isHave) {
            System.out.printf("No more free space! You need %d Cubic meters more.", needSpace);
        } else {
            int leftSpace = freeSpace - occupiedPlace;
            System.out.printf("%d Cubic meters left.", leftSpace);
        }
    }
}
