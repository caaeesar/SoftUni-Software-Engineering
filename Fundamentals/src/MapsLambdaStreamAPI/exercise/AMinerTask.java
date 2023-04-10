package MapsLambdaStreamAPI.exercise;

import java.util.*;

public class AMinerTask {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourceQuantity = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!"stop".equals(command)) {

            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());

            Integer currentQuantity = resourceQuantity.get(resource);
            if (currentQuantity == null) {
                currentQuantity = 0;
            }
            resourceQuantity.put(resource, currentQuantity + quantity);
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resourceQuantity.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
