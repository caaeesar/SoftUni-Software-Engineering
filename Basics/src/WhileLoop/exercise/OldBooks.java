package WhileLoop.exercise;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String favoriteBook = scanner.nextLine();
        String currentBook = scanner.nextLine();
        int countBooks = 0;

       /* while (true) {
          String currentBook = scanner.nextLine();

            if (currentBook.equals(favoriteBook)) {
                System.out.printf("You checked %d books and found it.", countBooks);
                break;
            }
            if (currentBook.equals("No More Books")) {
                System.out.println("The book you search is not here!");
                System.out.printf("You checked %d books.", countBooks);
                break;
            }
            ++countBooks;
        }          */

        boolean isFound = false;
        while (!currentBook.equals("No More Books")) {

            if (currentBook.equals(favoriteBook)) {
                isFound = true;
                break;
            }
           ++countBooks;
                 currentBook = scanner.nextLine();
        }
        if (isFound) {
            System.out.printf("You checked %d books and found it.", countBooks);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", countBooks);
        }
    }
}