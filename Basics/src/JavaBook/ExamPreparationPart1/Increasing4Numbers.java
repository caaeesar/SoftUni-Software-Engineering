package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class Increasing4Numbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        boolean isHave = false;

        for (int n1 = 1; n1 <= b; n1++) {

            for (int n2 = 1; n2 <= b; n2++) {

                for (int n3 = 1; n3 <= b; n3++) {

                    for (int n4 = 1; n4 <= b; n4++) {

                        boolean isValid = (a <= n1) && (n1 < n2) && (n2 < n3) && (n3 < n4) && (n4 <= b);
                        if (isValid) {
                            isHave = true;
                            System.out.printf("%d %d %d %d\n", n1, n2, n3, n4);
                        }
                    }
                }
            }
        }
        if (!isHave) {
            System.out.print("No");
        }
    }
}
