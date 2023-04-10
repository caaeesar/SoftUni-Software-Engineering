package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
//todo
        Deque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .forEach(males::push);

        Deque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .forEach(females::offer);

        int matchesCount = 0;
        int maleValue;
        int femaleValue;

        while (!males.isEmpty() && !females.isEmpty()) {

            maleValue = males.peek();
            femaleValue = females.peek();

            boolean isAnyZero = maleValue == 0 || femaleValue == 0;
            boolean isSpecialCase = maleValue % 25 == 0 || femaleValue % 25 == 0;

            if (isAnyZero) {
                if (maleValue <= 0) {
                    males.pop();
                    if (males.size() > 1) {
                        maleValue = males.peek();
                    }
                }
                if (femaleValue <= 0) {
                    females.poll();
                    if (females.size() >= 1) {
                        femaleValue = females.peek();
                    }
                }
            } else if (isSpecialCase) {
                if (maleValue % 25 == 0) {
                    males.pop();
                    if (males.size() > 1) {
                        males.pop();

                    }
                }

                if (femaleValue % 25 == 0) {
                    females.poll();
                    if (females.size() >= 1) {
                        females.poll();
                    }
                }
            }
            if (maleValue == femaleValue) {
                matchesCount++;
                males.pop();
                females.poll();
            } else  {
                if (!females.isEmpty() && !males.isEmpty()) {
                    females.poll();
                    maleValue -= 2;
                    males.pop();
                    males.push(maleValue);
                }
            }

        }

        System.out.printf("Matches: %d\n", matchesCount);

        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            String leftMales = String.join(", ", males.toString());
            System.out.printf("Males left: %s\n", leftMales);
        }

        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String leftFemales = String.join(", ", females.toString());
            System.out.printf("Females left: %s", leftFemales);
        }
    }
}
