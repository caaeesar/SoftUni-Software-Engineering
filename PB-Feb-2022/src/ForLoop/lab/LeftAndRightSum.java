package ForLoop.lab;

import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int leftSum = 0;
        int rightSum = 0;

        // * първи начин
        // четем 2 * n на брой числа => 2 цикъла правим

      /*  for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            leftSum += number;
        }
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            rightSum += number;
        }

       if (leftSum == rightSum) {
           System.out.printf("Yes, sum = %d", leftSum);
       } else {
           System.out.printf("No, diff = %d",Math.abs(leftSum - rightSum));
       } */

        // * втори начин -> правим един цикъл

        for (int i = 1; i <= 2 * n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (i <= n) { // първата група числа;
                leftSum += number;
            } else { // (i > n) втората група числа
              rightSum += number;
            }
        }
        if (leftSum == rightSum) {
            System.out.printf("Yes, sum = %d", leftSum);
        } else {
            System.out.printf("No, diff = %d",Math.abs(leftSum - rightSum));
        }
    }
}
