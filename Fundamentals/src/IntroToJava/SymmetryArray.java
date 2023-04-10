package IntroToJava;

import java.util.Scanner;

public class SymmetryArray {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // един масив е симетричен ако първият и последният му елемент са еднакви;
        // вторият и предпоследният и т.н;
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];

        for (int index = 0; index < array.length; index++) {

            array[index] = Integer.parseInt(scanner.nextLine());
        }
        boolean symmetric = true;

        //обхождаме масива до неговата среда
        for (int index = 0; index < array.length / 2; index++) {

            if (array[index] != array[n - index - 1]) {
                symmetric = false;
            }
        }
        System.out.printf("Symmetric? %b", symmetric);
    }
}
