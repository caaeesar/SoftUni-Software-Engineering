package JavaBook;

public class NumbersEndingIn7 {
    public static void main(String[] arguments) {

        for (int i = 1; i <= 1000; i++) {
            if (i % 10 == 7) {
                System.out.println(i);
            }
        }
    }
}
