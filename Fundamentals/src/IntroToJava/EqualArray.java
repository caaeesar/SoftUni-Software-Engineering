package IntroToJava;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArray {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfBGWeek = scanner.nextLine().split(" ");
        String[] daysOfUSAWeek = scanner.nextLine().split(" ");

        boolean isEqual = Arrays.equals(daysOfBGWeek, daysOfUSAWeek);

        System.out.println();
        System.out.println(isEqual);

    }
}
