package JavaBook.ProblemsForChampionsPart1;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class MagicDates {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int startYear = Integer.parseInt(scanner.nextLine());
        int endYear = Integer.parseInt(scanner.nextLine());
        int magicWeight = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        //използваме класът LocalDate, която се грижи за това колко дни има в месеците;
        LocalDate startDate = LocalDate.of(startYear, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(endYear, Month.DECEMBER, 31);

        LocalDate currentDate = startDate;
        // използваме методите .isBefore и .isEqual:
        while (currentDate.isBefore(endDate) || currentDate.isEqual(endDate)) {

            // чрез метода .getDayOfMonth() взимаме деня;
            int d1 = currentDate.getDayOfMonth() / 10;
            int d2 = currentDate.getDayOfMonth() % 10;

           // чрез метода .getMonthValue() взимаме месеца;
            int d3 = currentDate.getMonthValue() / 10;
            int d4 = currentDate.getMonthValue() % 10;

          // чрез метода .getYear() взимаме годината;
            int d5 = currentDate.getYear() / 1000;
            int d6 = (currentDate.getYear() / 100) % 10;
            int d7 = (currentDate.getYear() / 10) % 10;
            int d8 = currentDate.getYear() % 10;

            int dateWeight = d1 * (d2 + d3 + d4 + d5 + d6 + d7 + d8) +
                    d2 * (d3 + d4 + d5 + d6 + d7 + d8) +
                    d3 * (d4 + d5 + d6 + d7 + d8) +
                    d4 * (d5 + d6 + d7 + d8) +
                    d5 * (d6 + d7 + d8) +
                    d6 * (d7 + d8) +
                    d7 * d8;

            if (magicWeight == dateWeight) {
                isFound = true;
                //използваме класът, за да форматираме датата;
              //  DateTimeFormatter output = DateTimeFormatter.ofPattern("dd-MM-yyyy");
              //  System.out.println(output.format(currentDate));
                System.out.printf("%1$td-%1$tm-%1$tY\n", currentDate);
            }
            // използваме метода .plusDays, за да увеличаваме деня:
            currentDate = currentDate.plusDays(1);
        }
        if (!isFound) {
            System.out.println("No");
        }
    }
}
