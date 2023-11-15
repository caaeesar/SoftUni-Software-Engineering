package bg.softuni.plannerapp.model.entity;

import bg.softuni.plannerapp.model.entity.enums.PriorityName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "priorities")
@Getter
@Setter
@NoArgsConstructor
public class Priority extends BaseEntity {

    @Column(name = "priority_name", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PriorityName priorityName;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "priority", targetEntity = Task.class)
    private List<Task> tasks;

    public Priority(PriorityName priorityName) {
        this.priorityName = priorityName;
    }
}
