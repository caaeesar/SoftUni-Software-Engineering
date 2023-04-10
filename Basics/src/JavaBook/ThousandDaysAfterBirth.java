package JavaBook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ThousandDaysAfterBirth {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String birthDay = scanner.nextLine();

        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate after1000d = LocalDate.parse(birthDay, date).plusDays(1000);

        System.out.println(date.format(after1000d));
    }
}
