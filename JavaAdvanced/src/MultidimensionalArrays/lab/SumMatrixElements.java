package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = matrixReader(size[0], scanner);
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += Arrays.stream(matrix[i]).sum();
        }
        System.out.println(sum);
        System.out.println(size[0]);
        System.out.println(size[1]);
    }
    public static int[][] matrixReader(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];
        for (int r = 0; r < rows; r++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[r] = currentRow;
        }
        return matrix;
    }
}
