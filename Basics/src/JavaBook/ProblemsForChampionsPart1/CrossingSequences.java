package JavaBook.ProblemsForChampionsPart1;

import java.util.Scanner;

public class CrossingSequences {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // първите три числа на Трибоначи:
        // всяко следващо число е сбора от предходните три;
        int t0 = Integer.parseInt(scanner.nextLine());
        int t1 = Integer.parseInt(scanner.nextLine());
        int t2 = Integer.parseInt(scanner.nextLine());

        // първото число от числовата спирала:
        int firstNumber = Integer.parseInt(scanner.nextLine());
        // стъпка на увеличение:
        int step = Integer.parseInt(scanner.nextLine());

        int tn = 0;
        int tribonacciCount = 0;

        int spiralCount = 0;
        int spiralNumber = firstNumber;
        int spiralStepMul = 1;

        boolean isFound = false;

        while (tn <= 1000000 && spiralNumber <= 1000000) {

            tribonacciCount++;
            if (tn == spiralNumber) {
                System.out.print(spiralNumber);
                isFound = true;
                break;
            } else if (tn < spiralNumber) {

                if (tribonacciCount == 1) {
                    tn = t0;
                } else if (tribonacciCount == 2) {
                    tn = t1;
                } else if (tribonacciCount == 3) {
                    tn = t2;
                } else {
                    tn = t0 + t1 + t2;
                    t0 = t1;
                    t1 = t2;
                    t2 = tn;
                }
            } else {
                spiralNumber += step * spiralStepMul;
                spiralCount++;

                if (spiralCount % 2 == 0) {
                    spiralStepMul++;
                }
            }
        }
        if (!isFound) {
            System.out.println("No");
        }

        /*
        // създаваме ArrayList, в който ще държим всички генерирани числа на Трибоначи;
        ArrayList<Integer> tribonacciNumbers = new ArrayList<>();
        tribonacciNumbers.add(t0);
        tribonacciNumbers.add(t1);
        tribonacciNumbers.add(t2);

        //генерираме всички числа от редицата на Трибоначи:
        int tn = 0;
        while (tn <= 1000000) {

            tn = t0 + t1 + t2;
            tribonacciNumbers.add(tn);

            t0 = t1;
            t1 = t2;
            t2 = tn;
        }

        //генерираме всички числа от числовата спирала:
        int spiralCount = 0;
        int spiralNumber = firstNumber;
        int spiralStepMul = 1;

        ArrayList<Integer> spiralNumbers = new ArrayList<>();
        spiralNumbers.add(firstNumber);

        while (spiralNumber <= 1000000) {

            spiralNumber += step * spiralStepMul;
            spiralNumbers.add(spiralNumber);
            spiralCount++;

            if (spiralCount % 2 == 0) {
                spiralStepMul++;
            }
        }

        boolean isFound = false;
        // обхождаме всички елементи от ArrayList-a, първия елемент е на позиция 0;
        for (int positionT = 0; positionT < tribonacciNumbers.size() - 1; positionT++) {

            for (int positionS = 0; positionS < spiralNumbers.size() - 1; positionS++) {

                if (tribonacciNumbers.get(positionT).equals(spiralNumbers.get(positionS))) {

                    if (tribonacciNumbers.get(positionT) <= 1000000) {
                        System.out.println(spiralNumbers.get(positionS));
                        isFound = true;
                        break;
                    }
                }
            }
            if (isFound) {
                break;
            }
        }

        if (!isFound) {
            System.out.println("No");
        } */
    }
}
