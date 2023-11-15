package bg.softuni.dictionaryapp.model.service;

import bg.softuni.dictionaryapp.model.entity.enums.LanguageName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WordServiceModel {

    private String term;

    private String translation;

    private String example;

    private LocalDate inputDate;

    private LanguageName language;
}
