package WhileLoop.exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double needMoney = Double.parseDouble(scanner.nextLine());
        double moneyOnHand = Double.parseDouble(scanner.nextLine());
        int spendDays = 0;
        boolean isEnough = false;
        int days = 0;

        while (moneyOnHand < needMoney) {

            String action = scanner.nextLine();
            double currentSum = Double.parseDouble(scanner.nextLine());
            ++days;

            switch (action) {
                case "spend":
                    moneyOnHand -= currentSum;
                    spendDays += 1; // така проверяваме дали 5 дни ПОСЛЕДОВАТЕЛНО харчи пари;
                    if (moneyOnHand < 0) {
                        moneyOnHand = 0;
                    }
                    break;
                case "save":
                    moneyOnHand += currentSum;
                    spendDays = 0;      // зануляваме когата събираме;
                    break;
            }
            // правим проверките извън switch-а, защото break-a в него има друга функция и не прекратява цикъла !!!
            if ( spendDays == 5) { // ако стигне до 5 и не се е занулявало, значи харчи 5 последователни дни;
                break;
            }
            if (moneyOnHand >= needMoney) {
                isEnough = true;
                break;
            }
        }

        if (isEnough) {
            System.out.printf("You saved the money for %d days.", days);
        } else {
            System.out.println("You can't save the money.");
            System.out.printf("%d", days);
        }
    }
}
