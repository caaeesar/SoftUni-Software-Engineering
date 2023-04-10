package Arrays.exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array1 = scanner.nextLine().split(" ");
        String[] array2 = scanner.nextLine().split(" ");

        for (String string : array2) {
            for (String str : array1) {

                if (string.equals(str)) {
                    System.out.print(str + " ");
                }
            }
        }
    }
}
