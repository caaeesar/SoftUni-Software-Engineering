package IntroToJava;

import java.util.Scanner;

public class DecimalToHexadecimal {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /* превръщане на число от десетична в шестнадесетична бройна система:
         А(p) => А - числото за преобразуване, то е в десетична бр.с-ма;
         p - бройната система към, която искаме да конвентираме */

        //  1. Разделяме А на р;
        //  2. Записваме остатъка;
        //  3. Продължаваме деленето, докато резултата не стане = 0;
        //  4. Записваме получените остатъци в обратен ред;

        int number = Integer.parseInt(scanner.nextLine());
        String allRemainder = convertInteger(number);
        String result = "";

        for (int position = allRemainder.length() - 1; position >= 0; position--) {

            char digit = allRemainder.charAt(position);
            result += digit;
        }
        System.out.printf("%d(10) = %s(16)", number, result);
    }

    static String convertInteger(int A) {

        String allRemainder = "";
        int currentDivider = Integer.MAX_VALUE;
        String symbols = "";

        while (currentDivider != 0) {

            currentDivider = A / 16;
            int currentRemainder = A % 16;
            A = currentDivider;

            if (currentRemainder >= 10 && currentRemainder <= 15) {

                switch (currentRemainder) {

                    case 10:
                        symbols = "A";
                        break;
                    case 11:
                        symbols = "B";
                        break;
                    case 12:
                        symbols = "C";
                        break;
                    case 13:
                        symbols = "D";
                        break;
                    case 14:
                        symbols = "E";
                        break;
                    case 15:
                        symbols = "F";
                        break;
                }
                allRemainder += symbols;
            } else {
                allRemainder += currentRemainder;
            }
        }
        return allRemainder;
    }
}
