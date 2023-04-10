package PFSchool;

import java.util.Scanner;

public class GetMiddleElements {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int[] numbers = new int[line.length];

        for (int index = 0; index < line.length; index++) {

            numbers[index] = Integer.parseInt(line[index]);
        }

        if (line.length == 1) {
            System.out.print(numbers[0]);
        } else if (line.length % 2 == 0) {
            System.out.println(numbers[numbers.length / 2 - 1]);
            System.out.println(numbers[numbers.length / 2]);
        } else {
            System.out.println(numbers[numbers.length / 2 - 1]);
            System.out.println(numbers[numbers.length / 2]);
            System.out.println(numbers[numbers.length / 2 + 1]);
        }
    }
}
