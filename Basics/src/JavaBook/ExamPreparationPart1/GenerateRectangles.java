package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class GenerateRectangles {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // 90/100
        int n = Integer.parseInt(scanner.nextLine()); // {n ; - n} -> max и min точки
        int m = Integer.parseInt(scanner.nextLine()); // най-малката възможна площ, която трябва да има правоъгълника;
        boolean isHave = false;

        // x1 и x2 - дължината на правоъгълника;
        // y1 и y2 - ширината на правоъгълника;

        for (int left = -n; left <= n; left++) { // x1

            for (int top = -n; top <= n; top++) { // y1

                for (int right = -n; right <= n; right++) { // x2

                    for (int bottom = -n; bottom <= n; bottom++) { // y2

                        int length = Math.max(left, right) - Math.min(left, right);
                        int width = Math.max(top, bottom) - Math.min(top, bottom);
                        int currentArea = width * length;

                        boolean isValid1 = (-n <= left) && (left < right) && (right <= n);
                        boolean isValid2 = (-n <= top) && (top < bottom) && (bottom <= n);

                        if (currentArea >= m && isValid1 && isValid2) {
                            System.out.printf("(%d, %d) (%d, %d) -> %d\n", left, top, right, bottom, currentArea);
                            isHave = true;
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
