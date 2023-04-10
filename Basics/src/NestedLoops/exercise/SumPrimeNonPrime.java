package NestedLoops.exercise;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int simpleSum = 0;
        int noSimpleSum = 0;

        while (!input.equals("stop")) {

            int currentNumber = Integer.parseInt(input);
            boolean isSimple = true;

            if (currentNumber < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue; // тази команда пропуска целия код отдолу и отива в while цикъла
            }
            //просто число -> всяко число, което е по-голямо от едно и има точно два делителя 1 и самото себе си;
            // правим цикъл за делителите
            // започваме от 2, защото всяко число се дели на 1 (не ни трябва тази итерация)
            // не слагаме = на второто условие в цикъла, защото всяко число се дели на себе си (-//-)
            for (int divider = 2; divider < currentNumber; divider++) {

                if (currentNumber % divider == 0) { // ако влезем в тази проверка, значи числото има повече от два делителя => е съставно и не е просто
                    noSimpleSum += currentNumber;
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) { // ако влезнем значи числото няма повече от 2 делителя
                simpleSum += currentNumber;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d\n", simpleSum);
        System.out.printf("Sum of all non prime numbers is: %d", noSimpleSum);
    }
}
