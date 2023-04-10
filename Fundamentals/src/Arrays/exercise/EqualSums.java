package Arrays.exercise;

/*import java.util.Scanner;

public class EqualSums {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = readArray(array);
        boolean isFoundIndex = false;
        int leftSum = 0;
        int rightSum = 0;
        int getIndex = -1;

        // search by position
        for (int position = 0; position < numbers.length; position++) {

            // take the left sum according to the position
            for (int index = 0; index < position ; index++) {
                leftSum += numbers[index];
            }

            // take the right sum from next position to end
            for (int index = position + 1; index < numbers.length; index++) {
                rightSum += numbers[index];
            }
            if (leftSum == rightSum) {
                getIndex = position;
                isFoundIndex = true;
                break;
            } else {
                leftSum = 0;
                rightSum = 0;
            }
        }
        if (isFoundIndex) {
            System.out.print(getIndex);
        } else {
            System.out.print("no");
        }
    }

    static int[] readArray(String[] array) {
        int[] numbers = new int[array.length];
        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
        return numbers;
    }
}*/
import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isHaveIndex = false;

        for (int index = 0; index < sequence.length; index++) {

            int leftSum = getLeftSum(sequence, index);
            int rightSum = getRightSum(sequence, index);

            if (leftSum == rightSum) {
                System.out.print(index);
                isHaveIndex = true;
                break;
            }
        }

        if (!isHaveIndex) {
            System.out.print("no");
        }
    }

    public static int getLeftSum(int[] sequence, int index) {
        int leftSum = 0;
        for (int i = 0; i < index; i++) {
            leftSum += sequence[i];
        }
        return leftSum;
    }

    public static int getRightSum(int[] sequence, int index) {
        int rightSum = 0;
        for (int i = index + 1; i < sequence.length; i++) {
            rightSum += sequence[i];
        }
        return rightSum;
    }

}
