package SetsAndMaps.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class LogsAggregator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> usersLogs = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String[] parts = scanner.nextLine().split("\\s+");
            String ip = parts[0];
            String user = parts[1];
            int duration = Integer.parseInt(parts[2]);

            Map<String, Integer> logSession = usersLogs.get(user);
            if (logSession == null) {
                logSession = new TreeMap<>();
            }

            Integer currentDuration = logSession.get(ip);
            if (currentDuration == null) {
                currentDuration = 0;
            }
            logSession.put(ip, currentDuration + duration);
            usersLogs.put(user, logSession);
        }
        usersLogs.forEach((user, log) -> System.out.printf("%s: %d %s\n",
                user,
                log.values().stream().reduce(0, Integer::sum),
                log.keySet()));
    }
}
