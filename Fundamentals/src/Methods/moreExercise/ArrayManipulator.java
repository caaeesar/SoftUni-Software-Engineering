package Methods.moreExercise;

import java.util.*;

public class ArrayManipulator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];
        readArray(array, numbers);

        String command = scanner.nextLine();
        int index;
        int count;

        while (!command.equals("end")) {

            String[] currentManipulation = command.split(" ");
            switch (currentManipulation[0]) {

                case "exchange":
                    index = Integer.parseInt(currentManipulation[1]);
                    if (index < 0 || index > numbers.length - 1) {
                        System.out.println("Invalid index");
                    }
                    exchange(numbers, index);
                    break;
                case "max":

                    switch (currentManipulation[1]) {
                        case "even":
                            int maxEvenElement = getIndexOfMaxEvenElement(numbers);
                            if (maxEvenElement == -1) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(maxEvenElement);
                            }
                            break;
                        case "odd":
                            int maxOddElement = getIndexOfMaxOddElement(numbers);

                            if (maxOddElement == -1) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(maxOddElement);
                            }
                            break;
                    }
                    break;
                case "min":
                    switch (currentManipulation[1]) {
                        case "even":
                            int minEvenElement = getIndexOfMinEvenElement(numbers);

                            if (minEvenElement == -1) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(minEvenElement);
                            }
                            break;
                        case "odd":
                            int minOddElement = getIndexOfMinOddElement(numbers);

                            if (minOddElement == -1) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(minOddElement);
                            }
                            break;
                    }
                    break;
                case "first":
                    switch (currentManipulation[2]) {
                        case "even":
                            count = Integer.parseInt(currentManipulation[1]);

                            if (count > numbers.length) {
                                System.out.println("Invalid count");
                            } else {
                                printFirstNEvenElement(numbers, count);
                            }
                            break;
                        case "odd":
                            count = Integer.parseInt(currentManipulation[1]);

                            if (count > numbers.length) {
                                System.out.println("Invalid count");
                            } else {
                                printFirstNOddElement(numbers, count);
                            }
                            break;
                    }

                    break;
                case "last":
                    switch (currentManipulation[2]) {
                        case "even":
                            count = Integer.parseInt(currentManipulation[1]);

                            if (count > numbers.length) {
                                System.out.println("Invalid count");
                            } else {
                                printLastNEvenElement(numbers, count);
                            }
                            break;
                        case "odd":
                            count = Integer.parseInt(currentManipulation[1]);

                            if (count > numbers.length) {
                                System.out.println("Invalid count");
                            } else {
                                printLastNOddElement(numbers, count);
                            }
                            break;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void printLastNOddElement(int[] numbers, int count) {
        System.out.print("[");
        int currentLastOdd = -1;
        int countElements = 0;
        List<String> element = new ArrayList<>();

        for (int i = numbers.length - 1; i >= 0; i--) {

            if (numbers[i] % 2 == 1) {
                currentLastOdd = numbers[i];
                if (countElements == 0) {
                        element.add(String.valueOf(currentLastOdd));
                } else {
                        element.add(String.valueOf(currentLastOdd));
                }
                countElements++;
            }
            if (count == countElements) {
                break;
            }
        }
        Collections.reverse(element);
        System.out.print(String.join(", ", element));
        System.out.print("]");
        System.out.println();
    }

    private static void printLastNEvenElement(int[] numbers, int count) {
        System.out.print("[");
        int currentLastEven = -1;
        int countElements = 0;
        List<String> element = new ArrayList<>();

        for (int i = numbers.length - 1; i >= 0; i--) { // take last ones

            if (numbers[i] % 2 == 0) {
                currentLastEven = numbers[i];
                if (countElements == 0) {
                        element.add(String.valueOf(currentLastEven));
                } else {
                        element.add(String.valueOf(currentLastEven));
                }
                countElements++;
            }
            if (count == countElements) {
                break;
            }
        }
        Collections.reverse(element); // print them from left to right
        System.out.print(String.join(", ", element));
        System.out.print("]");
        System.out.println();
    }

    private static void printFirstNOddElement(int[] numbers, int count) {
        System.out.print("[");
        int currentOddElement = -1;
        int countElements = 0;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 2 == 1) {
                currentOddElement = numbers[i];
                if (countElements == 0) {
                        System.out.print(currentOddElement);
                } else {
                    System.out.print(", ");
                        System.out.print(currentOddElement);
                }
                countElements++;
            }
            if (count == countElements) {
                break;
            }
        }
        System.out.print("]");
        System.out.println();
    }

    private static void printFirstNEvenElement(int[] numbers, int count) {
        System.out.print("[");
        int currentEvenElement = -1;
        int countElements = 0;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 2 == 0) {
                currentEvenElement = numbers[i];
                if (countElements == 0) { // in case which have only one element
                        System.out.print(currentEvenElement);
                } else {
                    System.out.print(", ");
                        System.out.print(currentEvenElement);
                }
                countElements++;
            }
            if (count == countElements) {
                break;
            }
        }
        System.out.print("]");
        System.out.println();
    }

    private static int getIndexOfMinOddElement(int[] numbers) {
        int minOddElement = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            int currentElement = numbers[i];

            if (currentElement % 2 == 1) {

                if (currentElement <= minOddElement) {
                    minOddElement = currentElement;
                    index = i;
                }
            }
        }
        return index;
    }

    private static int getIndexOfMinEvenElement(int[] numbers) {
        int minEvenElement = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            int currentElement = numbers[i];

            if (currentElement % 2 == 0) {

                if (currentElement <= minEvenElement) {
                    minEvenElement = currentElement;
                    index = i;
                }
            }
        }
        return index;
    }

    private static int getIndexOfMaxOddElement(int[] numbers) {
        int maxOddElement = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            int currentElement = numbers[i];

            if (currentElement % 2 == 1) {

                if (currentElement >= maxOddElement) {
                    maxOddElement = currentElement;
                    index = i;
                }
            }
        }
        return index;
    }

    private static int getIndexOfMaxEvenElement(int[] numbers) {
        int maxEvenElement = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            int currentElement = numbers[i];

            if (currentElement % 2 == 0) {

                if (currentElement >= maxEvenElement) {
                    maxEvenElement = currentElement;
                    index = i;
                }
            }
        }
        return index;
    }

    private static void exchange(int[] numbers, int index) {
        // size of two new array
        int countFirstElements = 0;
        int countSecondElements = 0;
        for (int i = 0; i < numbers.length; i++) {

            if (i > index) {
                countSecondElements++;
            } else {
                countFirstElements++;
            }
        }
        int[] array1 = new int[countFirstElements];
        int[] array2 = new int[countSecondElements];

        int secondIndex = 0;
        for (int i = 0; i < numbers.length; i++) {

            if (i > index) { // fill second array
                array2[secondIndex] = numbers[i];
                secondIndex++;

            } else { // fill first array
                array1[i] = numbers[i];
            }
        }
        //exchange array1 and array2
        for (int i = 0; i < array2.length; i++) {
            numbers[i] = array2[i];
        }
        int j = array2.length;
        for (int i = 0; i < array1.length; i++) {
            numbers[j] = array1[i];
            j++;
        }
    }

    private static void readArray(String[] array, int[] numbers) {
        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
    }
}


