package IntroToJava;

import java.util.Scanner;
import java.util.Arrays;

public class ReadArray {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*int n = Integer.parseInt(scanner.nextLine());
        int [] myArray = new int[n];

        for (int index = 0; index < myArray.length; index++) {

            myArray [index] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(Arrays.toString(myArray));*/
////////////////////////////////////////////////////////////////////////////////////////
        String[] capitals = new String[]{"Sofia", "Washington", "London", "Paris"};

        //for-each
        for (String currentCapital : capitals) {
            System.out.println(currentCapital);
        }

    }
}
