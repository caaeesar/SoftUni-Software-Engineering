package JavaBook.ComplexLoopsExamProblems;

import java.util.Scanner;

public class StupidPasswordGenerator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());

        for (int symbol1 = 1; symbol1 <= n; symbol1++) {
        int countS3 = 0;
        int countS4 = 0;

            for (int symbol2 = 1; symbol2 <= n; symbol2++) {

                for (char symbol3 = 'a'; symbol3 <= 'z'; symbol3++) {
                    countS3++;

                    for (char symbol4 = 'a'; symbol4 <= 'z'; symbol4++) {
                        countS4++;

                        for (int symbol5 = 1; symbol5 <= n; symbol5++) {

                            boolean isValidS5 = symbol5 > symbol1 && symbol5 > symbol2;
                            if (isValidS5 && (countS3 <= l) && (countS4 <= l)) {
                                System.out.printf("%d%d%c%c%d ", symbol1,symbol2,symbol3,symbol4,symbol5);
                            }
                        }
                    }
                    countS4 = 0;
                }
                countS3 = 0;
            }
        }
    }
}
