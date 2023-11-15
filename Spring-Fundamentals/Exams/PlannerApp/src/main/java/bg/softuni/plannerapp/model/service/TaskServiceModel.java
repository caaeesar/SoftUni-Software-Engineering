package bg.softuni.plannerapp.model.service;

import bg.softuni.plannerapp.model.entity.enums.PriorityName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskServiceModel {

    private String description;

    private LocalDate dueDate;

    private PriorityName priority;
}
