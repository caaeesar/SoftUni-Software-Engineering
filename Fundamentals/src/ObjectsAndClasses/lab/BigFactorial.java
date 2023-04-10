package ObjectsAndClasses.lab;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);


        /*
         *
         int n = Integer.parseInt(scanner.nextLine());

         BigInteger factorial = calculateFactorial(n);
         System.out.println(factorial);
         }

         public static BigInteger calculateFactorial(int n) {
         BigInteger factorial = BigInteger.valueOf(1);
         for (int i = 2; i <= n; i++) {

         factorial = factorial.multiply(BigInteger.valueOf(i));
         }
         return factorial;
         }
         */

        long n = Long.parseLong(scanner.nextLine());
        BigInteger factorial = new BigInteger("1");

        for (long i = 2; i <= n ; i++) {
           factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }
}
