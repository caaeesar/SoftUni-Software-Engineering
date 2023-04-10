package ForLoop.moreExercise;

import java.util.Scanner;

public class Bills {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allMonth = Integer.parseInt(scanner.nextLine());
        double totalElectricity = 0;
        double totalOtherBill = 0.00;
        double totalWaterBill = 0.00;
        double totalInternetBill = 0.00;

        for (int month = 1; month <= allMonth; month++) {
            double currentElectricityBill = Double.parseDouble(scanner.nextLine());
            totalElectricity += currentElectricityBill;
            totalWaterBill = allMonth * 20;
            totalInternetBill = allMonth * 15;
            double currentOtherBill = currentElectricityBill + 20 + 15;
            currentOtherBill += currentOtherBill * 0.2;
            totalOtherBill += currentOtherBill;
        }
        double average = ((totalElectricity + totalWaterBill + totalInternetBill + totalOtherBill) / allMonth);

        System.out.printf("Electricity: %.2f lv\n", totalElectricity);
        System.out.printf("Water: %.2f lv\n", totalWaterBill);
        System.out.printf("Internet: %.2f lv\n", totalInternetBill);
        System.out.printf("Other: %.2f lv\n", totalOtherBill);
        System.out.printf("Average: %.2f lv", average);
    }
}
