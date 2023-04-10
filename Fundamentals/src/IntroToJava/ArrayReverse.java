package IntroToJava;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayReverse {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] myArray = new int[]{1, 2, 3, 4, 5};
        int length = myArray.length;

        int [] reversed = new int[myArray.length];

        for (int index = 0; index < length; index++) {

            reversed [length - index - 1] = myArray[index];
        }
        // с метода .toString получаваме текстово представяне на масива
        System.out.println(Arrays.toString(reversed));

        // втори начин:
        int [] array = new int[] {1, 2, 3, 4, 5};
        System.out.print("Reversed: ");

        for (int index = array.length - 1; index >= 0; index--) {
            System.out.print(array[index] + " ");
        }
    }
}
