package ObjectsAndClasses.lab;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        BigInteger number1 = scanner.nextBigInteger();
        BigInteger number2 = new BigInteger(scanner.nextLine());

        BigInteger sum = number1.add(number2);

        System.out.println(sum);
    }
}
