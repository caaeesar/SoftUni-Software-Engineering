package JavaBook.ComplexLoops;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        //факториел => всичките числа от 1 до n умножени едно с друго; факториел от 5 => 1 * 2 * 3 * 4 * 5
        int input = Integer.parseInt(scanner.nextLine());

       /* int multiplier = 1;
        int fact = 1;

        do {
            fact *= multiplier;
            multiplier++;
            System.out.println(fact);
        } while (multiplier <= input); */
/////////////////////////////////////////////////
       /* int result = 1;
        for (int i = 1; i <= input; i++) {

            result *= i;
        }
        System.out.println(result); */
/////////////////////////////////////////////////
        int fact = 1;
        int result = 1;

        while (fact <= input) {

            result *= fact;
            fact++;
        }
        System.out.print(result);

    }
}
