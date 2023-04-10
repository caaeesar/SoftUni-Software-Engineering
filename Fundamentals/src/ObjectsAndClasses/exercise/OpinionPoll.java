package ObjectsAndClasses.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {

    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return this.name + " - " + this.age;
        }
    }

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int currentPerson = 1; currentPerson <= lines; currentPerson++) {
            String[] personalInfo = scanner.nextLine().split(" ");
            String name = personalInfo[0];
            int age = Integer.parseInt(personalInfo[1]);
            Person person = new Person(name,age);
            people.add(person);
        }
        for (Person person : people) {
            if (person.getAge() > 30) {
                System.out.println(person);
            }
        }
    }
}
