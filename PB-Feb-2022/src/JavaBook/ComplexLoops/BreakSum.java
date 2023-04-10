package JavaBook.ComplexLoops;

public class BreakSum {
    public static void main(String[] arguments) {

        boolean isValid = true;

        for (int number1 = 1; number1 <= 3; number1++) {

            for (int number2 = 3; number2 >= 1; number2--) {

                if (number1 + number2 == 2) {
                    isValid = false;
                    break;
                } else {
                    System.out.printf("%d %d%n", number1, number2);
                }

            }
            if (!isValid) {
                break;
            }
        }

    }
}
