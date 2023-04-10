package others.humans;

public class Student extends Human implements Comparable<Student>{
    double grade;

    public Student(String name, String surname, double grade) {
        // invoke base constructor with key word 'super'
        super(name, surname);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f",this.name,this.grade);
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student student) {
        return Double.compare(this.grade, student.grade);
    }
}
