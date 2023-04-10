package InterfacesAndAbstraction.lab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String END = "End";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiableList = new ArrayList<>();
        Identifiable identifiable;
        String input = scanner.nextLine();

        while (!END.equals(input)) {

            String[] parts = input.split("\\s+");

            if (parts.length == 2) {

                String model = parts[0];
                String id = parts[1];

                identifiable = new Robot(id, model);

            } else  {

                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String id = parts[2];

                identifiable = new Citizen(name, age, id);
            }

            identifiableList.add(identifiable);
            input = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();

        identifiableList.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeId))
                .forEach(System.out::println);

    }
}
