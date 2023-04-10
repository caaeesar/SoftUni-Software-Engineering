package ObjectsAndClasses.exercise.opinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        List<Person> peopleList = new ArrayList<>(numberOfPeople);

        for (int currentPerson = 1; currentPerson <= numberOfPeople; currentPerson++) {

            String[] personInfo = scanner.nextLine().split(" ");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));

            peopleList.add(person);
        }
        peopleList.stream().filter(person -> person.getAge() > 30).forEach(System.out::println);
    }
}
