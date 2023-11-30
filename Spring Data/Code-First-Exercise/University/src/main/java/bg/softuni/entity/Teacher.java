package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "teachers")
public class Teacher extends Person {

    private String email;
    @Column(name = "salary_per_hour")
    private double salaryPerHour;
    @OneToMany
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private List<Course> courses;

}
