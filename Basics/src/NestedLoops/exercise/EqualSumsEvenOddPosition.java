package NestedLoops.exercise;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        //  *ПЪРВИ НАЧИН*
       /*
        //вход
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        // взимаме числата в диапазона между първото и второто число
        for (int currentNum = number1; currentNum <= number2; currentNum++) {

            // зануляваме стойностите след всяко число
            int oddSum = 0;
            int evenSum = 0;
            boolean isEven = true; // започваме от 6-та позиция, която е четна
            int currentNumber = currentNum; // презаписваме настоящето число от цикъла в нова променлива

            // въртим цикъла докато не свършат всички цифри:
            while (currentNumber != 0) {

                int lastDigit = currentNumber % 10; //взимаме последната цифра на числото
                currentNumber = currentNumber / 10; // премахваме последната цифра от числото

                if (isEven) {
                    evenSum += lastDigit;
                } else {
                    oddSum += lastDigit;
                }
                // редуваме позициите (четни / нечетни)
                isEven = !isEven; // обратното на true е false и обратното на false e true
            }
            if (evenSum == oddSum) {
                System.out.printf("%d ", currentNum);
            }
        } */

        // *ВТОРИ НАЧИН*
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        for (int i = number1; i <= number2; i++) {

            int oddSum = 0;
            int evenSum = 0;
            String currentNumber = i + ""; // превръщаме текущото число в текст

            for (int position = 0; position < currentNumber.length(); position++) {

                int currentDigit = Integer.parseInt(currentNumber.charAt(position) + "");

                if (position % 2 == 0) {
                    evenSum += currentDigit;
                } else {
                    oddSum += currentDigit;
                }
            }
            if (oddSum == evenSum) {
                System.out.printf("%d ", i);
            }
        }
        // *ТРЕТИ НАЧИН*

        /*int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        for (int i = num1; i <= num2; i++) {

            int firstDigit = i / 100000; //понеже е от целочислен тип реже остатъка
            int secondDigit = i / 10000 % 10; // след като разделим получаваме двуцифрено число, за да вземем втората цифра делим модулно на 10
            int thirdDigit = i / 1000 % 10; // трицифрено число
            int fourDigit = i / 100 % 10; // четирицифрено число
            int fifthDigit = i / 10 % 10; // петцифрено число
            int sixDigit = i % 10; // взимаме последната цифра

            int oddSum = firstDigit + thirdDigit + fifthDigit;
            int evenSum = secondDigit + fourDigit + sixDigit;

            if (oddSum == evenSum) {
                System.out.print(i + " ");
            }
        }*/
         // Решение с два For-цикъла
        /*
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int currentNum = start; currentNum <= end; currentNum++) {
            int evenSum = 0;
            int oddSum = 0;

            int copyNumber = currentNum;
            for (int digit = 6; digit >= 1; digit--) {

                int lastDigit = copyNumber % 10;

                if (digit % 2 == 0) {
                    evenSum += lastDigit;
                } else {
                    oddSum += lastDigit;
                }
                copyNumber /= 10;
                isEven = !isEven;
            }
            if (oddSum == evenSum) {
                System.out.printf("%d ", currentNum);

            }
        }
         */

    }
}

