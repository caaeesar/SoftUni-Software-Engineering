package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int rows1 = Integer.parseInt(scanner.next());
        int columns1 = Integer.parseInt(scanner.next());
        int[][] matrix1 = new int[rows1][columns1];
        for (int r = 0; r < rows1; r++) {
            for (int c = 0; c < columns1; c++) {
                matrix1[r][c] = Integer.parseInt(scanner.next());
            }
        }

        int rows2 = Integer.parseInt(scanner.next());
        int columns2 = Integer.parseInt(scanner.next());
        int[][] matrix2 = new int[rows2][columns2];
        for (int r = 0; r < rows2; r++) {
            for (int c = 0; c < columns2; c++) {
                matrix2[r][c] = Integer.parseInt(scanner.next());
            }
        }

        // aко общия брой на елементите е различен
        // проверявам броя на колоните:
        if ((rows1 * columns1) != (rows2 * columns2)) {
            System.out.print("not equal");
            return;
        }
        boolean isEqualArray = compareArrays(matrix1, matrix2);
        if (isEqualArray) {
            System.out.print("equal");
        } else {
            System.out.print("not equal");
        }
    }

    public static boolean compareArrays(int[][] matrix1, int[][] matrix2) {
        // проверявам броя на редовете:
        if (matrix1.length != matrix2.length) {
            return false;
        } else {
            for (int r = 0; r < matrix1.length; r++) {
                for (int c = 0; c < matrix1[r].length; c++) {
                    if (matrix1[r][c] != matrix2[r][c]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
       /*// ако първия от двумерните масиви масив са различни:
        if (matrix1.length != matrix2.length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
           // сравняване елементите на двете матрици ред по ред
            if (!Arrays.equals(matrix1[i], matrix2[i])) {
                return false;
            }
        }
        return true;
    }*/
}
