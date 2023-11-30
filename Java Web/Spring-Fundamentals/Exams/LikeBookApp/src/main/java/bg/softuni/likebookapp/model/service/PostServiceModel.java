package bg.softuni.likebookapp.model.service;

import bg.softuni.likebookapp.model.entity.enums.MoodType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostServiceModel {

    private String content;

    private MoodType mood;
}
