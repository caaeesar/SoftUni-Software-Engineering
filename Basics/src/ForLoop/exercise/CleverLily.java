package ForLoop.exercise;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double priceWashMachine = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());

        double money = 0.00;
        int oddBirthdays = 0;
        int evenBirthdays = 0;
        double savedMoney = 0.00;


        for (int birthdays = 1; birthdays <= age; birthdays++) {

            if (birthdays % 2 == 0) { // четни рожденни дни;
                money += 10.00; // сумата се увеличава с 10лв на всеки следващ четен рожден ден
                savedMoney += money;
                ++evenBirthdays;
            } else { // нечетни рожденни дни
                ++oddBirthdays;
            }
        }

        double takenMoney = evenBirthdays * 1.00; // общо взетите пари
        int moneyFromToys = oddBirthdays * priceToy; // парите, които ще получи след като продаде играчките;
        double totalMoney = (savedMoney + moneyFromToys) - takenMoney;

        if (totalMoney >= priceWashMachine) {
            double leftMoney = totalMoney - priceWashMachine;
            System.out.printf("Yes! %.2f", leftMoney);
        } else {
            double needMoney = priceWashMachine - totalMoney;
            System.out.printf("No! %.2f", needMoney);
        }
    }
}
