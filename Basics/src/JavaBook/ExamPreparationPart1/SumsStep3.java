package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class SumsStep3 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // четем броя на числата, които ще бъдат подадени
        int sum1 = 0; // в тази променлива се сумират числата, започвайки от първото число и всяко следващо (през 3 числа) със стъпка три;
        int sum2 = 0; // сумират се числата, започвайки от второто подред число и всяко следващо (през 3 числа) със стъпка три;
        int sum3 = 0; // сумират се числата, започвайки от третото подред число и всяко следващо (през 3 числа) със стъпка три;

        for (int i = 0; i < n; i++) {

            // четем текущото число:
            int currentNumber = Integer.parseInt(scanner.nextLine());

            // числата по условие се сумират със стъпка 3 (през 3), затова делим модулно на 3;
            // чрез модулно делене разбираме, кое подред е числото и го прибавяме към съответната сума;

            if (i % 3 == 0) {
                sum1 += currentNumber;
            }
            if (i % 3 == 1) {
                sum2 += currentNumber;
            }
            if (i % 3 == 2) {
                sum3 += currentNumber;
            }
        }
        System.out.printf("sum1 = %d\n", sum1);
        System.out.printf("sum2 = %d\n", sum2);
        System.out.printf("sum3 = %d", sum3);
    }
}
