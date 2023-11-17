package bg.softuni.plannerapp.model.binding;

import bg.softuni.plannerapp.model.entity.enums.PriorityName;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class TaskAddBindingModel {

    @NotBlank(message = "Description cannot be empty!")
    @Length(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    private String description;

    @DateTimeFormat(pattern = "YY/MM/DD")
    @FutureOrPresent(message = "Due Date must be in future!")
    private LocalDate dueDate;

    @NotNull(message = "You must select a priority!")
    private PriorityName priority;
}
