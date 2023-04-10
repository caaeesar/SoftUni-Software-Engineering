package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalsOfSquareMatrix {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] firstDiagonal = new int[size];
        int[] secondDiagonal = new int[size];

        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            firstDiagonal[index] = matrix[i][i];
            index++;
        }

        index = 0;
        int cols = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            secondDiagonal[index] = matrix[i][cols];
            index++;
            cols++;
        }
        System.out.println(Arrays.toString(firstDiagonal).replaceAll("[\\[\\],]", ""));
        System.out.println(Arrays.toString(secondDiagonal).replaceAll("[\\[\\],]", ""));
    }
}
