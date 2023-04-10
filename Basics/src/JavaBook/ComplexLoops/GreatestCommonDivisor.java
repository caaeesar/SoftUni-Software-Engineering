package JavaBook.ComplexLoops;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        //АЛГОРИТЪМ НА ЕВКЛИД => НАЙ-ГОЛЯМ ОБЩ ДЕЛИТЕЛ
        // 1. За делимо се взима по-голямото число, а за делител – по-малкото число.
        // 2. Делителят от предишната стъпка се разделя на получения остатък.
        // 3. Това се повтаря дотогава, докато получим остатък 0.
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int divisor = Math.max(a, b);
        int divider = Math.min(a, b);
        int result = 1;

        while (result != 0) {

            int overage = divisor % divider;
            divisor = divider;
            divider = overage;
            result = overage;
        }
        System.out.print(divisor);
    }
}

