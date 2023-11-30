package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id;

    @Column(name = "full_name", columnDefinition = "VARCHAR(40)")
    private String name;

    @Column(name = "avg_grade", columnDefinition = "DECIMAL(19,4)")
    private double averageGrade;

    public Student(String name, double averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public Student() {}

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
