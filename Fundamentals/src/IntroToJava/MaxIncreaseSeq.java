package IntroToJava;

import java.util.Scanner;

public class MaxIncreaseSeq {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // TODO: don't work
        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];
        readArray(array, numbers);

        int currentNumber = 0;
        int nextNumber = 0;
        int countElements = 0;
        String sequence = "";
        int maxElements = 0;
        String maxSeq = "";
        boolean isSequence = true;
        boolean isHaveMAx = false;

        for (int index = 0; index < numbers.length; index++) {

            if (index == numbers.length - 1) {
                if (isSequence) {
                    currentNumber = numbers[index];
                    sequence += currentNumber;
                    countElements++;
                }
            } else {
                currentNumber = numbers[index];
                nextNumber = numbers[index + 1];
            }

            if (nextNumber > currentNumber) {
                countElements++;
                sequence += currentNumber;
                isSequence = true;
            } else if (index != numbers.length - 1) {
                if (isSequence) {
                    sequence += currentNumber;
                    maxSeq = sequence;
                    maxElements = countElements + 1;
                }
                countElements = 0;
                sequence = "";
                isSequence = false;
            }
            if (countElements > maxElements) {
                maxElements = countElements;
                maxSeq = sequence;
                isHaveMAx = true;
            } else if (countElements == maxElements && index == numbers.length - 1 && !isHaveMAx) {
                System.out.println("There is no such sequence!");
                return;
            }
        }
        if (maxElements == 1) {
            System.out.println("There is no such sequence!");
            return;
        }
        String[] result = maxSeq.split("");
        System.out.println(String.join(" ", result));
    }

    static void readArray(String[] array, int[] numbers) {
        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
    }
}

