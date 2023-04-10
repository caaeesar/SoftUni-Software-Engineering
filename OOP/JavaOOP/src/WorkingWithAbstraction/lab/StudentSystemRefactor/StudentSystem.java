package WorkingWithAbstraction.lab.StudentSystemRefactor;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> dataSystem;

    public StudentSystem() {
        this.dataSystem = new HashMap<>();
    }

    public Map<String, Student> getDataSystem() {
        return this.dataSystem;
    }

    public void showStudent(String name) {
        if (this.dataSystem.containsKey(name)) {
            Student student = this.dataSystem.get(name);
            System.out.println(student);
        }
    }

    public void createStudent(String name, int age, double grade) {
        if (!dataSystem.containsKey(name)) {
            Student newStudent = new Student(name,age,grade);
            dataSystem.put(name, newStudent);
        }
    }
}
