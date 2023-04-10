package IntroToJava;

public class MaxSubmatrix {
    public static void main(String[] arguments) {

        int[][] matrix = {
                {0, 2, 4, 0, 9, 5},
                {7, 1, 3, 3, 2, 1},
                {1, 3, 9, 8, 5, 6},
                {4, 6, 7, 9, 1, 0}
        };

        int maxSum = Integer.MIN_VALUE;
        int firstRow = 0;
        int firstCol = 0;

        for (int row = 0; row < matrix.length - 1 ; row++) { // то 0 до 3 вкл.

            // до дължината на текущия ред //
            for (int col = 0; col < matrix[row].length - 1; col++) { // от 0 до 5 вкл.

                // размер 2 х 2
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    firstRow = col;
                    firstCol = col;
                }
            }
        }
        System.out.printf("%d %d%n", matrix[firstRow][firstCol], matrix[firstRow][firstCol + 1]);
        System.out.printf("%d %d", matrix[firstRow + 1][firstCol], matrix[firstRow + 1][firstCol + 1]);

    }
}
