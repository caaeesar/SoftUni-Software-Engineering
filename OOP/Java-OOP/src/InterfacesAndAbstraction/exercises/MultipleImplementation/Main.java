package InterfacesAndAbstraction.exercises.MultipleImplementation;

import java.util.*;

public class Main {

    public static final String STOP_COMMAND = "End";

    public static void main(String[] args) {

       /* Class[] citizenInterfaces = Citizen.class.getInterfaces();

        if (Arrays.asList(citizenInterfaces).contains(InterfacesAndAbstraction.exercise.MultipleImplementation.Person.class)) {

            Method[] fields = InterfacesAndAbstraction.exercise.MultipleImplementation.Person.class.getDeclaredMethods();
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            InterfacesAndAbstraction.exercise.MultipleImplementation.Person person = new Citizen(name, age);

            System.out.println(fields.length);
            System.out.println(person.getName());
            System.out.println(person.getAge());
        }*/
       /* Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {

            Method[] methods = Birthable.class.getDeclaredMethods();
            Method[] methods1 = Identifiable.class.getDeclaredMethods();

            Scanner scanner = new Scanner(System.in);

            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthDate = scanner.nextLine();

            Identifiable identifiable = new Citizen(name, age, id, birthDate);
            Birthable birthable = new Citizen(name, age, id, birthDate);

            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            System.out.println(methods1.length);
            System.out.println(methods1[0].getReturnType().getSimpleName());
        }*/

       /* Scanner scanner = new Scanner(System.in);

        List<Birthable> birthableObjects = new ArrayList<>();
        String input = scanner.nextLine();
        while (!STOP_COMMAND.equals(input)) {

            String[] data = input.split("\\s+");
            String name;
            String birthdate;
            String id;

            if (input.contains("Citizen")) {

                name = data[1];
                int age = Integer.parseInt(data[2]);
                id = data[3];
                birthdate = data[4];

                Citizen citizen = new Citizen(name, age, id, birthdate);
                birthableObjects.add(citizen);

            } else if (input.contains("Pet")) {

                name = data[1];
                birthdate = data[2];

                Pet pet = new Pet(name, birthdate);
                birthableObjects.add(pet);

            } else if (input.contains("Robot")) {

                String model = data[1];
                id = data[2];

                Robot robot = new Robot(id,model);

            }

            input = scanner.nextLine();
        }

        String searchBirth = scanner.nextLine();
        birthableObjects
                .stream()
                .map(Birthable::getBirthDate)
                .filter(e -> e.endsWith(searchBirth))
                .forEach(System.out::println);*/

        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> nameBuyerObjects = new HashMap<>();

        int nPeople = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nPeople; i++) {

            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Buyer buyer;

            if (data.length == 3) {
                String group = data[2];
                buyer =  new Rebel(name,age,group);
            } else {
                String id = data[2];
                String birthdate = data[3];
                buyer = new Citizen(name,age,id,birthdate);
            }

            nameBuyerObjects.putIfAbsent(name,buyer);
        }

        String name = scanner.nextLine();
        while (!STOP_COMMAND.equals(name)) {
            Buyer buyer = nameBuyerObjects.get(name);
            if (buyer != null) {
                buyer.buyFood();
            }
            name = scanner.nextLine();
        }

        System.out.print(nameBuyerObjects.values().stream().mapToInt(Buyer::getFood).sum());

    }
}
