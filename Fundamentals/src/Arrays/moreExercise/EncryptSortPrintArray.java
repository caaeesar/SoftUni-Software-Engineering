package Arrays.moreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {

            String currentStr = scanner.nextLine();
            int vowelSum = 0;
            int consonantSum = 0;
            for (int position = 0; position < currentStr.length(); position++) {

                char letter = currentStr.charAt(position);
                switch (letter) {
                    case 'A':
                    case 'a':
                    case 'E':
                    case 'e':
                    case 'I':
                    case 'i':
                    case 'O':
                    case 'o':
                    case 'U':
                    case 'u':
                        vowelSum += (letter * currentStr.length());
                        break;
                    default:
                        consonantSum += (letter / currentStr.length());
                        break;
                }
            }
                int totalSum = summingTotalSum(vowelSum, consonantSum);
                array[i] = totalSum;
        }
        Arrays.sort(array);
        for (int currentSum : array) {
            System.out.printf("%d%n", currentSum);
        }
    }

    static int summingTotalSum(int vowelSum, int consonantSum) {
        return vowelSum + consonantSum;
    }
}
