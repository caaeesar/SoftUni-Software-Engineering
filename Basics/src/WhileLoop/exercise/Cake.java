package WhileLoop.exercise;

import java.util.Scanner;

public class Cake {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int cake = width * length;
        String input = scanner.nextLine();
        boolean isMore = true;
        int availablePiece = 0;
        int needPiece = 0;

        while (!input.equals("STOP")) {

            int currentPieces = Integer.parseInt(input);
            cake -= currentPieces;
            availablePiece = cake;

            if (availablePiece <= 0) {
                needPiece = Math.abs(availablePiece);
                isMore = false;
                break;
            }
            input = scanner.nextLine();
        }
        if (input.equals("STOP")) {
            System.out.printf("%d pieces are left.", availablePiece);
        }
        if (!isMore) {
            System.out.printf("No more cake left! You need %d pieces more.", needPiece);
        }
    }
}
