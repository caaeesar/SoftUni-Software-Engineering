package bg.softuni.plannerapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    @NotBlank
    private String description;

    @Column(name = "due_date", nullable = false)
    @FutureOrPresent
    private LocalDate dueDate;

    @ManyToOne
    @NotNull
    private Priority priority;

    @ManyToOne
    private User user;

}
