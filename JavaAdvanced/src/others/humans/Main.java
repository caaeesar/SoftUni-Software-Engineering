package others.humans;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arguments) {
        Worker worker = new Worker("Melissa", "Rudeva", 50, 5);
        System.out.println(worker.calculationHourlyWage());
        System.out.println(worker);

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("Melisa", "Rudeva", 2.00));
        studentsList.add(new Student("Georgi", "Georgiev", 5.00));
        studentsList.add(new Student("Pesho", "Peshov", 4.00));
        studentsList.add(new Student("Ann", "Angelova", 6.00));

        studentsList
                .stream()
                .sorted((st1, st2) -> Double.compare(st2.getGrade(),st1.getGrade()))
                .forEach(System.out::println);

        List<Worker> workerList = new ArrayList<>();
        workerList.add(new Worker("Melisa", "Rudeva", 500));
        workerList.add(new Worker("Georgi", "Georgiev", 700));
        workerList.add(new Worker("Melisssssa", "Rudeva", 100000));
        workerList.add(new Worker("Pesho", "Peshov", 40));

        workerList.stream().sorted((w1,w2) -> Double.compare(w2.getSalary(), w1.getSalary())).forEach(System.out::println);
    }
}
