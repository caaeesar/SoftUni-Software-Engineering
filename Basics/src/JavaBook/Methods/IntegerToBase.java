package JavaBook.Methods;

import java.util.Scanner;

public class IntegerToBase {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

         /* превръщане на числа в различни бройни системи:
         А(p) => А - числото за преобразуване, то е в десетична бр.с-ма;
         p - бройната система към, която искаме да конвентираме */

        // * метод за конвертиране на бр.с-ми между 2 и 10 * //

        //  1. Разделяме А на р;
        //  2. Записваме остатъка;
        //  3. Продължаваме деленето, докато резултата не стане = 0;
        //  4. Записваме получените остатъци в обратен ред;

        int number = Integer.parseInt(scanner.nextLine()); // number > 0
        int system = Integer.parseInt(scanner.nextLine());
        int length = integerToBase(number, system).length();
        String totalRest = integerToBase(number, system);
        String result = "";

        for (int position = length - 1; position >= 0; position--) {

            char digit = totalRest.charAt(position);
            result += digit;
        }
        System.out.print(result);
    }

    public static String integerToBase(int A, int p) {

        String totalRest = "";
        int currentResult = Integer.MAX_VALUE;

        while (currentResult != 0) {

            currentResult = A / p;
            int currentRest = A % p;
            A = currentResult;
            totalRest += currentRest;

        }
        return totalRest;
    }
}
