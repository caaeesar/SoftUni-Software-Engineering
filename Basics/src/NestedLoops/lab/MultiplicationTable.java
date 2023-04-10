package NestedLoops.lab;

public class MultiplicationTable {
    public static void main(String[] arguments) {

        for (int multiplier1 = 1; multiplier1 <= 10; multiplier1++) {

            for (int multiplier2 = 1; multiplier2 <= 10; multiplier2++) {

                int result = multiplier1 * multiplier2;

                System.out.printf("%d * %d = %d\n", multiplier1, multiplier2, result);
            }
        }
    }
}
