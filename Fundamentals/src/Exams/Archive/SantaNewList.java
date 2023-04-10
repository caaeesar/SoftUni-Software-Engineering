package Exams.Archive;

import java.util.*;

public class SantaNewList {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> childPoint = new TreeMap<>();
        Map<String, Integer> presentAmount = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {

            String[] parts = input.split("->");
            String childName;

            if (parts.length == 2) {

                childName = parts[1];
                childPoint.remove(childName);

            } else {

                childName = parts[0];
                String typePresent = parts[1];
                int count = Integer.parseInt(parts[2]);

                Integer currentPoint = childPoint.get(childName);
                if (currentPoint == null) {
                    currentPoint = 0;
                }
                currentPoint += count;
                childPoint.put(childName, currentPoint);

                Integer currentAmount = presentAmount.get(typePresent);
                if (currentAmount == null) {
                    currentAmount = 0;
                }
                currentAmount += count;
                presentAmount.put(typePresent, currentAmount);
            }
            input = scanner.nextLine();
        }
        System.out.println("Children:");
        childPoint.entrySet().stream().sorted((c1, c2) -> {
            int sort = Integer.compare(c2.getValue(), c1.getValue());
            if (sort == 0) {
                sort = c1.getKey().compareTo(c2.getKey());
            }
            return sort;
        }).forEach(c -> System.out.printf("%s -> %d\n", c.getKey(), c.getValue()));

        System.out.println("Presents:");
        presentAmount.forEach((key, value) -> System.out.printf("%s -> %d\n", key, value));
    }
}
