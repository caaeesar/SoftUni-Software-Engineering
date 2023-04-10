package WhileLoop.moreExercise;

public class NumbersDividedBy3WithoutReminder {
    public static void main(String[] arguments) {

        int number = 3;
        while (number <= 100) {
            if (number % 3 == 0) {
                System.out.println(number);
            }
            ++number;
        }
    }
}
