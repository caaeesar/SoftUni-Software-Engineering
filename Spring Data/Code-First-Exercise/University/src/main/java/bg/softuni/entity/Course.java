package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "courses")
public class Course extends BaseEntity {

    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    private Long credits;

    @ManyToMany(mappedBy = "courses", targetEntity = Student.class)
    private List<Student> students;

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

}
