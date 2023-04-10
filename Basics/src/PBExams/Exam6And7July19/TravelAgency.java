package PBExams.Exam6And7July19;

import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        String kindPackage = scanner.nextLine();
        String vip = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        if (days < 1) {
            System.out.print("Days must be positive number!");
            return;
        } else if (days > 7) {
            days--;
        }

        boolean isHaveDiscount = false;
        if (vip.equals("yes")) {
            isHaveDiscount = true;
        }

        double price = 0.00;
        double discount = 0.00;

        switch (kindPackage) {

            case "withEquipment":

                switch (town) {

                    case "Bansko":
                    case "Borovets":

                        price = 100;

                        if (isHaveDiscount) {
                            discount = price * 0.10;
                        }
                        break;
                    default:
                        System.out.print("Invalid input!");
                        return;
                }
                break;
            case "noEquipment":

                switch (town) {

                    case "Bansko":
                    case "Borovets":

                        price = 80;

                        if (isHaveDiscount) {
                            discount = price * 0.05;
                        }
                        break;
                    default:
                        System.out.print("Invalid input!");
                        return;
                }
                break;
            case "withBreakfast":

                switch (town) {

                    case "Varna":
                    case "Burgas":

                        price = 130;

                        if (isHaveDiscount) {
                            discount = price * 0.12;
                        }
                        break;
                    default:
                        System.out.print("Invalid input!");
                        return;
                }
                break;
            case "noBreakfast":

                switch (town) {

                    case "Varna":
                    case "Burgas":

                        price = 100;

                        if (isHaveDiscount) {
                            discount = price * 0.07;
                        }
                        break;
                    default:
                        System.out.print("Invalid input!");
                        return;
                }
                break;
            default:
                System.out.print("Invalid input!");
                return;
        }
        double totalSum = (price - discount) * days;
        System.out.printf("The price is %.2flv! Have a nice time!", totalSum);
    }
}
