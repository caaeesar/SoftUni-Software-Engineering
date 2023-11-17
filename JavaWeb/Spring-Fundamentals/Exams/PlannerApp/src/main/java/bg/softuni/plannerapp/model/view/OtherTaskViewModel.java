package bg.softuni.plannerapp.model.view;

import bg.softuni.plannerapp.model.entity.enums.PriorityName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OtherTaskViewModel {

    private String id;
    private LocalDate dueDate;

    private PriorityName priority;

    private String description;
}
