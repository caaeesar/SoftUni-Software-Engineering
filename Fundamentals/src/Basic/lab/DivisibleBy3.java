package Basic.lab;

public class DivisibleBy3 {
    public static void main(String[] arguments) {

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}
