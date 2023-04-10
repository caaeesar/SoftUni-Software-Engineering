package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class IncreasingElements {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int previousNumber = 0;
        int countElements = 0;
        int currentLongest = 0;

        for (int currentRow = 1; currentRow <= input; currentRow++) {

            int currentNumber = Integer.parseInt(scanner.nextLine());

            if (currentNumber > previousNumber) {
                countElements++;
            } else {
                countElements = 1; // заради първата итерация
            }
                if (countElements > currentLongest) {
                    currentLongest = countElements;
                }
            previousNumber = currentNumber;
        }
            System.out.println(currentLongest);
    }
}



