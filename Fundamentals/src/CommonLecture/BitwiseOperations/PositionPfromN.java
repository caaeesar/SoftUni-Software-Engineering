package CommonLecture.BitwiseOperations;

import java.util.Scanner;

public class PositionPfromN {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // Трябва да вземем позицията р от числото n

        int p = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        int mask = n >> p;
        int bit = mask & 1;

        System.out.println(bit);
    }
}
