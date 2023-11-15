package bg.softuni.likebookapp.model.binding;

import bg.softuni.likebookapp.model.entity.enums.MoodType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PostAddBindingModel {

    @NotBlank
    @Length(min = 2, max = 150, message = "Content length must be between 2 and 150 characters!")
    private String content;

    @NotNull(message = "You must select mood!")
    private MoodType mood;
}
