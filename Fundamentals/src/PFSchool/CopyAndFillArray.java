package PFSchool;

import java.util.Arrays;
import java.util.Scanner;

public class CopyAndFillArray {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] array1 = new int[] {8,9,10,11,12};

        System.out.println("First array is:");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }

        int[] array2 = Arrays.copyOf(array1,array1.length - 3);


        System.out.println("New array after copying elements is:");
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

        int[] array = {7, 8, 9, 10, 11};

        Arrays.fill(array, 2, 5, 0); // Replace elements from index 2 to index 4 by 0

        System.out.println(Arrays.toString(array));


        int[] arr = {6, 7, 8, 9, 10};

        Arrays.fill(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
