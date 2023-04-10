package ForLoop.moreExercise;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int firstPair = 0;
        int secondPair = 0;
        int n = Integer.parseInt(scanner.nextLine());
        int maxDiff = 0;
        boolean isPair = false;

        for (int i = 1; i <= n; i++) {
            int currentNumber1 = Integer.parseInt(scanner.nextLine());
            int currentNumber2 = Integer.parseInt(scanner.nextLine());

            firstPair = currentNumber1 + currentNumber2;

            if (i == 1) {
                secondPair = firstPair;
                isPair = true;
            }
            if (firstPair == secondPair && i > 1) {
                isPair = true;
            }
            if (firstPair != secondPair) {
                int diff = Math.abs(firstPair - secondPair);
                secondPair = firstPair;
                isPair = false;

                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        if (isPair) {
            System.out.printf("Yes, value=%d", firstPair);
        } else {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }

      /*  int n = Integer.parseInt(scanner.nextLine());
        int value = 0;
        int lastValue = 0;
        int count = 0;
        int maxDiff = 0;

        for (int i = 1; i <= n; i++) { // правим цикъла до n (<=), защото има 3 двойки числа;
            // на всяка итерация четем по две числа --> по една двойка;
            int firstNumber = Integer.parseInt(scanner.nextLine());
            int secondNumber = Integer.parseInt(scanner.nextLine());

            value = firstNumber + secondNumber;

            if (value == lastValue) {  // ако двете двойки числа имат еднаква сума:
                ++count;              // броим пътите // като накрая трябва да добавим 1 към брояча, за да добавим първата итерация;
            } else {
                // в първата итерация максималната разлика ще бъде текущата разлика и на следващите завъртания се променя според условието;
                // ако досегашната макс.разлика е по-малка от текущата => новата макс.разлика ще бъде текущата;
               int diff = Math.abs(value - lastValue); // абсолютната разлика на двете числа;
                if (maxDiff < diff && i >= 2) {
                    maxDiff = diff;
                }
            }
            // по условие ни трябва сумата на две последователни двойки
            if (value != lastValue) { // за първото завъртане това условие винаги е вярно;
                lastValue = value;    // текущата стойност трябва да стане последна такава преди четенето на нови числа;
                                      // ако двете стойности са еднакви няма нужда да променяме последната стойност,тя ще е същата;
            }
        }
        if (count + 1 == n) { // ако брояча + първата итерация е равна на броя двойки, значи всички двойки имат еднаква стойност
            System.out.printf("Yes, value=%d",value);
        } else {
            System.out.printf("No, maxdiff=%d",maxDiff);
        } */
    }
}