package Exams.Retake._01_.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        if (this.data.contains(student)) {
            return "Student is already in the hall.";
        } else {
            if (getCapacity() > getCount()) {
                this.data.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            }
        }
        return "The hall is full.";
    }

    public String remove(Student student) {
        if (this.data.remove(student)) {
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }
        return "Student not found.";
    }

    public Student getStudent(String firstName, String lastName) {
        Student searchStudent = null;
        for (Student student : this.data) {
            if (student.getFirstName().equals(firstName) &&
                    student.getLastName().equals(lastName)) {
                searchStudent = student;
                break;
            }
        }
        return searchStudent;
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format("Hall size: %d", this.data.size()));
        statistics.append(System.lineSeparator());
        for (Student student : this.data) {
            statistics.append(student);
            statistics.append(System.lineSeparator());
        }
        return statistics.toString();
    }
}
