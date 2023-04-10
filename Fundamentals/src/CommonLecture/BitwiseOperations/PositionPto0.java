package CommonLecture.BitwiseOperations;

import java.util.Scanner;

public class PositionPto0 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // На позиция р трябва да сложим 0;

        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        int mask = ~(1 << p);

        int result = n & mask;
        System.out.println(result);
    }
}
