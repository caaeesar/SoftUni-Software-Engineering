package JavaBook.Methods;

import java.util.Scanner;

public class NthDigit {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int index = Integer.parseInt(scanner.nextLine());
        System.out.print(findNthDigit(number, index));
    }

    static int findNthDigit(int number, int index) {

        int n = 0; // броя на индексите
        while (number > 0) {

            int currentIndex = number % 10;
            n++;

            if (n == index) {

                return currentIndex;
            } else {
                number /= 10;
            }
        }
        return number;
    }
}
