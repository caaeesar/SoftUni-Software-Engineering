package bg.softuni.dictionaryapp.model.binding;

import bg.softuni.dictionaryapp.model.entity.enums.LanguageName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
public class WordAddBindingModel {

    @NotBlank(message = "Term cannot be empty!")
    @Length(min = 2, max = 40, message = "Term length must be between 2 and 40 characters!")
    private String term;

    @NotBlank(message = "Translation cannot be empty!")
    @Length(min = 2, max = 80, message = "Translation length must be between 2 and 80 characters!")
    private String translation;

    @Length(min = 2, max = 200, message = "Example length must be between 2 and 200 characters!")
    private String example;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "The input date must be a date in the past or present!")
    @NotNull(message = "You must select a data!")
    private LocalDate inputDate;

    @NotNull(message = "You must select a language!")
    private LanguageName language;
}
