package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        if (decimalNumber == 0) {
            System.out.print("0");
            return;
        }
        Deque<Integer> reminder = new ArrayDeque<>();

        while (decimalNumber > 0){
            int currentBit = decimalNumber % 2;
            decimalNumber /= 2;
            reminder.push(currentBit);
        }
        for (Integer integer : reminder) {
            System.out.print(integer);
        }
    }
}
