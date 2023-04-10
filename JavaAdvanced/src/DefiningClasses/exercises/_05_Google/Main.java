package DefiningClasses.exercises._05_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {

            String name = input.split("\\s")[0];
            Person person = people.get(name);
            if (person == null) {
                person = new Person(name);
            }

            if (input.contains("company")) {
                //"{Name} company {companyName} {department} {salary}"
                String companyName = input.split("\\s")[2];
                String department = input.split("\\s")[3];
                double salary = Double.parseDouble(input.split("\\s")[4]);
                // inner class -> static or non-static
                // why is static ??
                Person.Company company = new Person.Company(companyName, department, salary);
                person.setCompany(company);

            } else if (input.contains("pokemon")) {
                //"{Name} pokemon {pokemonName} {pokemonType}"
                String pokemonName = input.split("\\s")[2];
                String type = input.split("\\s")[3];

                Person.Pokemon pokemon = new Person.Pokemon(pokemonName, type);
                person.addPokemon(pokemon);

            } else if (input.contains("parents")) {
                //"{Name} parents {parentName} {parentBirthday}"
                String parentName = input.split("\\s")[2];
                String birthday = input.split("\\s")[3];

                Person.Parent parent = new Person.Parent(parentName, birthday);
                person.addParent(parent);

            } else if (input.contains("children")) {
                //"{Name} children {childName} {childBirthday}"
                String childName = input.split("\\s")[2];
                String birthday = input.split("\\s")[3];

                Person.Child child = new Person.Child(childName, birthday);
                person.addChild(child);

            } else if (input.contains("car")) {
                //"{Name} car {carModel} {carSpeed}"
                String model = input.split("\\s")[2];
                int speed = Integer.parseInt(input.split("\\s")[3]);
                Person.Car car = new Person.Car(model, speed);
                person.setCar(car);
            }

            people.put(name, person);
            input = scanner.nextLine();
        }

        String searchName = scanner.nextLine();
        Person person = people.get(searchName);
        System.out.println(person.getName());

        Person.Car car = person.getCar();
        Person.Company company = person.getCompany();
        boolean isHaveCar = true;
        boolean isHaveCompany = true;
        if (car == null) {
            isHaveCar = false;
        }
        if (company == null) {
            isHaveCompany = false;
        }

        //fixme
        if (!isHaveCar && !isHaveCompany) {
            System.out.println("Company:");
            System.out.println("Car:");
        }else if (isHaveCar && isHaveCompany) {
            System.out.println("Company:");
            System.out.printf("%s\n",person.getCompany());
            System.out.println("Car:");
            System.out.printf("%s\n",person.getCar());
        } else if (isHaveCar && !isHaveCompany) {
            System.out.println("Company:");
            System.out.println("Car:");
            System.out.printf("%s\n",person.getCar());
        } else if (!isHaveCar && isHaveCompany) {
            System.out.println("Company:");
            System.out.printf("%s\n",person.getCompany());
            System.out.println("Car:");
        }

        System.out.println("Pokemon:");
        for (Person.Pokemon pokemon : person.getAllPokemon()) {
            System.out.println(pokemon);
        }

        System.out.println("Parents:");
        for (Person.Parent parent : person.getParents()) {
            System.out.println(parent);
        }

        System.out.println("Children:");
        for (Person.Child child : person.getChildren()) {
            System.out.println(child);
        }
    }
}
