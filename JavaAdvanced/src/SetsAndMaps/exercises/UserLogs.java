package SetsAndMaps.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserLogs {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {

            String[] parts = input.split(" ");
            String ip = parts[0].split("=")[1];
            String user = parts[2].split("=")[1];

            Map<String, Integer> ipCount = userLogs.get(user);
            if (ipCount == null) {
                ipCount = new LinkedHashMap<>();
            }

            Integer count = ipCount.get(ip);
            if (count == null) {
                count = 0;
            }

            ipCount.put(ip, count + 1);
            userLogs.put(user, ipCount);

            input = scanner.nextLine();
        }
        userLogs.forEach((user, ipCount) -> {
            System.out.println(user + ":");
            AtomicInteger countIP = new AtomicInteger(1);
            ipCount.forEach((ip, count) -> {

                if (countIP.get() == ipCount.size()) {
                    System.out.printf("%s => %d.\n", ip, count);
                } else {
                    System.out.printf("%s => %d, ", ip, count);
                }
                countIP.getAndIncrement();
            });
        });
    }
}
