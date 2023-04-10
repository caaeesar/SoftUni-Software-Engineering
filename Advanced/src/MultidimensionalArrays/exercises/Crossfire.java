package MultidimensionalArrays.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = size[0];
        int cols = size[1];

        List<List<Integer>> field = new ArrayList<>();
        fill2DArr(field, rows, cols);

        String input = scanner.nextLine();
        while (!"Nuke it from orbit".equals(input)) {

            int[] coordinates = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = coordinates[0];
            int col = coordinates[1];
            int radius = coordinates[2];

            findVerticalCells(field, row, col, radius);
            findHorizontalCells(field, row, col, radius);

            for (List<Integer> currentRow : field) {
                destroyingCells(currentRow);
            }

            field.removeIf(List::isEmpty); // ако някой от списъците няма вече елементи го премахваме
            input = scanner.nextLine();
        }
        print2DArr(field);
    }

    private static void destroyingCells(List<Integer> currentRow) {
        currentRow.removeIf(e -> e == -1);
        /*while (currentRow.contains(-1)) {
            currentRow.remove(currentRow.indexOf(-1));
        }*/
    }

    private static void print2DArr(List<List<Integer>> twoDimensionalArr) {
        for (List<Integer> arr : twoDimensionalArr) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBoundField(int row, int col, List<List<Integer>> field) {
        return row >= 0 && row < field.size() && col >= 0 && col < field.get(row).size();
    }

    private static void findHorizontalCells(List<List<Integer>> field, int row, int col, int radius) {
        for (int currentCol = col - radius; currentCol <= col + radius; currentCol++) {
            if (isInBoundField(row, currentCol, field)) {
                field.get(row).set(currentCol, -1);
            }
        }
    }

    private static void findVerticalCells(List<List<Integer>> field, int row, int col, int radius) {
        for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
            if (isInBoundField(currentRow, col, field)) {
                field.get(currentRow).set(col, -1);
            }

        }
    }

    private static void fill2DArr(List<List<Integer>> field, int rows, int cols) {
        int value = 1;
        for (int r = 0; r < rows; r++) {
            List<Integer> list = new ArrayList<>();
            for (int c = 0; c < cols; c++) {
                list.add(value++);
            }
            field.add(list);
        }
    }
}
