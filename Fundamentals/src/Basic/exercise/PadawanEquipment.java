package Basic.exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double priceOfSaber = Double.parseDouble(scanner.nextLine());
        double priceOfRobe = Double.parseDouble(scanner.nextLine());
        double priceOfBelt = Double.parseDouble(scanner.nextLine());

        double additionSabers = Math.ceil(studentsCount * 0.1);
        int freeBelts = studentsCount / 6; // всеки 6ти колан е безплатен

        double totalSabersPrice = (studentsCount + additionSabers) * priceOfSaber;
        double totalRobesPrice = studentsCount * priceOfRobe;
        double totalBeltPrice = (studentsCount - freeBelts) * priceOfBelt;

        double totalPrice = totalBeltPrice + totalRobesPrice + totalSabersPrice;

        if (totalPrice <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - money);
        }
    }
}
