package StacksAndQueues.exercises;

import java.util.*;

public class Robotics {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] allRobots = Arrays.stream(scanner.nextLine().split(";"))
                .toArray(String[]::new);

        LinkedHashMap<String, Integer> robotsProcessTime = getRobots(allRobots);
        int[] workingTime = new int[robotsProcessTime.size()];

        String[] inputTime = scanner.nextLine().split(":");
        int hours = Integer.parseInt(inputTime[0]);
        int minutes = Integer.parseInt(inputTime[1]);
        int seconds = Integer.parseInt(inputTime[2]);
        int startTimeInSeconds = convertAllTimeInSeconds(hours, minutes, seconds);

        Deque<String> products = getProducts(scanner);

        while (!products.isEmpty()) {
            startTimeInSeconds++;
            String currentProduct = products.poll();
            boolean isTaken = false;
            decreasingWorkTime(workingTime);

            for (int i = 0; i < workingTime.length; i++) {

                if (workingTime[i] == 0) {
                    int countRobot = 0;
                    for (Map.Entry<String, Integer> robot : robotsProcessTime.entrySet()) {

                        if (countRobot == i) {
                            workingTime[i] = robot.getValue();
                            isTaken = true;
                            String outputTime = formattingTime(startTimeInSeconds);
                            System.out.printf("%s - %s %s%n", robot.getKey(), currentProduct, outputTime);
                            break;
                        }
                        countRobot++;
                    }
                    break;
                }
            }
            if (!isTaken) {
                products.offer(currentProduct);
            }
        }
    }

    private static void decreasingWorkTime(int[] workingTime) {
        for (int i = 0; i < workingTime.length; i++) {
            int currentWorkingTime = workingTime[i];
            if (currentWorkingTime > 0) {
                workingTime[i] = --currentWorkingTime;
            }
        }
    }

    private static int convertAllTimeInSeconds(int hours, int minutes, int seconds) {
        return (hours * 3600) + (minutes * 60) + seconds;
    }

    private static Deque<String> getProducts(Scanner scanner) {
        Deque<String> products = new ArrayDeque<>(); // queue
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            products.offer(input);
            input = scanner.nextLine();
        }
        return products;
    }

    private static LinkedHashMap<String, Integer> getRobots(String[] allRobots) {
        LinkedHashMap<String, Integer> robotsTime = new LinkedHashMap<>();
        for (String robotInfo : allRobots) {
            String robotName = robotInfo.split("-")[0];
            int processTime = Integer.parseInt(robotInfo.split("-")[1]);
            robotsTime.put(robotName, processTime);
        }
        return robotsTime;
    }

    private static String formattingTime(int totalSeconds) {
        long hours = (totalSeconds / 3600) % 24;
        long minutes = totalSeconds % 3600 / 60;
        long seconds = totalSeconds % 60;
        return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
    }
}
