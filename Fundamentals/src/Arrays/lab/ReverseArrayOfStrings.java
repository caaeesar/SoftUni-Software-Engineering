package Arrays.lab;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int length = array.length;

        for (int index = 0; index < length / 2; index++) {
            String swapVar = array[index];
            array[index] = array[length - 1 - index];
            array[length - 1 - index] = swapVar;
        }
        for (String str : array) {
            System.out.print(str + " ");
        }
    }
}
