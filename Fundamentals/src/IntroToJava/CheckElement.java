package IntroToJava;

import java.util.Scanner;

public class CheckElement {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // 1. check if there is such position in array => arr.length
        // 2. check if the element of this position is smaller or bigger
        // 3. check if the position of array is first and last

        int position = Integer.parseInt(scanner.nextLine());
        String[] arr = scanner.nextLine().split("");
        int[] numbers = readIntArray(arr);
        boolean check = checkPosition(numbers, position);

        if (check) {
            String result = checkElements(numbers, position);
            System.out.printf("The element is %s", result);
        }
    }

    static int[] readIntArray(String[] arr) {
        int[] numbers = new int[arr.length];
        for (int index = 0; index < arr.length; index++) {
            numbers[index] = Integer.parseInt(arr[index]);
        }
        return numbers;
    }

    static boolean checkPosition(int[] numbers, int position) {
        if (position <= numbers.length - 1) {
            return true;
        } else {
            throw new ArrayIndexOutOfBoundsException("There is no such position of this array");
        }
    }

    static String checkElements(int[] numbers, int position) {

        String biggerOrSmaller = "";
        boolean isSmaller = false;
        boolean isBigger = false;
        for (int index = 0; index < numbers.length; index++) {

            if (position == index) {

                if (position == 0) {

                    isBigger = numbers[index] > numbers[index + 1];
                    isSmaller = numbers[index] < numbers[index + 1];

                } else if (position == numbers.length - 1) {

                    isBigger = numbers[index] > numbers[index - 1];
                    isSmaller = numbers[index] < numbers[index - 1];

                } else {
                    isBigger = (numbers[index] > numbers[index + 1]) && (numbers[index] > numbers[index - 1]);
                    isSmaller = (numbers[index] < numbers[index + 1]) && (numbers[index] < numbers[index - 1]);
                }
                if (isBigger) {
                    biggerOrSmaller = "bigger";
                } else if (isSmaller) {
                    biggerOrSmaller = "smaller";
                }
            }
        }
        return biggerOrSmaller;
    }
}
