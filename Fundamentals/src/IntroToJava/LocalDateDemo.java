package IntroToJava;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateDemo {
    public static void main(String[] arguments) {

        LocalDateTime now = LocalDateTime.now(); // статичен метод на класа
        System.out.println(now);
        LocalDateTime yesterday = now.minusDays(1);
        System.out.println(yesterday);
        LocalDate myDay = LocalDate.of(2002,7,25);
        System.out.println(myDay);
        boolean isLeap = myDay.isLeapYear();
        System.out.println(isLeap);

    }
}
