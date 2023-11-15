package bg.softuni.dictionaryapp.model.view;

import bg.softuni.dictionaryapp.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseWordViewModel {

    private String id;

    private String term;

    private String translation;

    private String example;

    private LocalDate inputDate;

    private User addedBy;

    protected BaseWordViewModel(String id, String term, String translation, String example, LocalDate inputDate, User addedBy) {
        this.id = id;
        this.term = term;
        this.translation = translation;
        this.example = example;
        this.inputDate = inputDate;
        this.addedBy = addedBy;
    }
}
