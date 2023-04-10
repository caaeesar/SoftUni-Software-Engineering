package Arrays.moreExercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KaminoFactory {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
//todo
        int length = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int[] bestDNA = new int[length];
        int countSequence = 0;
        int maxCountOfOnes = Integer.MIN_VALUE; // най-големия брой единици
        int bestCount = 0;

        int startingIndex = -1; // индекса на първата поредица от 1-ци
        int maxStartingIndex = -1;

        int maxSum = -1;
        while (!"Clone them!".equals(command)) {
            int[] DNA = Arrays.stream(command.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int sumOfAllElement = 0;
            int currentCountOnes = 0;
            int index = 0;
            while (index <= DNA.length - 1) { // last element
                if (index == length - 1) {
                    int element = DNA[index];
                    sumOfAllElement += element;
                    break;
                }
                if (DNA[index] == 1 && DNA[index + 1] == 1) {
                    currentCountOnes += 2;
                    startingIndex = index;
                }
                int element = DNA[index];
                sumOfAllElement += element;
                index++;
            }
            countSequence++;
            if (currentCountOnes > maxCountOfOnes) {
                bestDNA = DNA;
                maxCountOfOnes = currentCountOnes;
                bestCount = countSequence;
                if (countSequence == 1) {
                    maxStartingIndex = startingIndex;
                    maxSum = sumOfAllElement;
                }
            } else if (currentCountOnes == maxCountOfOnes) {
                if (startingIndex < maxStartingIndex) {
                    maxStartingIndex = startingIndex;
                    bestDNA = DNA;
                    bestCount = countSequence;
                } else if (startingIndex == maxStartingIndex) {
                    if (sumOfAllElement > maxSum) {
                        maxSum = sumOfAllElement;
                        bestDNA = DNA;
                        bestCount = countSequence;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestCount, maxSum);
        for (int base : bestDNA) {
            System.out.print(base + " ");
        }
    }
}

