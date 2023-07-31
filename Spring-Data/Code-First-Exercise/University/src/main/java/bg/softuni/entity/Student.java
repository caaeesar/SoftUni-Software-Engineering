package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter@Getter
@Table(name = "students")
public class Student extends Person {

    @Column(name = "average_grade")
    private double averageGrade;
    private int attendance;
    @ManyToMany
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Set<Course> courses;

}
