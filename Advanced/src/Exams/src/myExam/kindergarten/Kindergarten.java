package myExam.kindergarten;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.registry.size() < this.capacity) {
            this.registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                return this.registry.remove(child);
            }
        }
        return false;
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return null;
    }

    ////ascending order
    //customersList.stream().sorted(Comparator.comparing(Customer::getAge)).forEach(System.out::println);
    ////descending order
    //studentsList.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).forEach(System.out::println);

    //by age ascending,
    // then by first name ascending,
    // then by last name ascending
    public String registryReport() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("Registered children in %s:",this.name));
        report.append(System.lineSeparator());
        report.append("--");
        report.append(System.lineSeparator());

        List<Child> sorted = this.registry.stream().sorted((child1, child2) -> {
            int result = Integer.compare(child1.getAge(), child2.getAge());
            if (result == 0) {
                result = child1.getFirstName().compareTo(child2.getFirstName());
                if (result == 0) {
                    result = child1.getLastName().compareTo(child2.getLastName());
                }
            }
            return result;
        }).collect(Collectors.toList());

        for (int i = 0; i < sorted.size(); i++) {
            Child child = sorted.get(i);
            report.append(child);
            report.append(System.lineSeparator());
            if (i != sorted.size() - 1){
            report.append("--");
            report.append(System.lineSeparator());
            }
        }

        return report.toString().trim();
    }

}
