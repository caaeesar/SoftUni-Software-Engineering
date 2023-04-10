package ConditionalStatements.moreExercise;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int vineYard = Integer.parseInt(scan.nextLine()); // кв.м лозе
        double grapes = Double.parseDouble(scan.nextLine()); // грозде за 1 кв.м
        int needLitres = Integer.parseInt(scan.nextLine()); // необходимите л. вино
        int countWorkers = Integer.parseInt(scan.nextLine());

        // 40% от лозето са за вино
        // 2.5 кг. грозде -> 1 л. вино

        double totalGrapes = vineYard * grapes; // общото кол. грозде от лозето
        double production = totalGrapes * 0.4; // грозде за производство на вино
        double totalLitres = production / 2.5; // литрите, които ще произведем

        boolean isEnough = totalLitres >= needLitres;
        if (isEnough) {
            double leftLitres = Math.ceil(totalLitres - needLitres);
            double forWorker = Math.ceil(leftLitres / countWorkers);
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n",totalLitres);
            System.out.printf("%.0f liters left -> %.0f liters per person.",leftLitres,forWorker);

        } else {
            double moreLitres = Math.floor(needLitres - totalLitres);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.",moreLitres);
        }
    }
}
