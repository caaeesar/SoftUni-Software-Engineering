package bg.softuni.dictionaryapp.model.entity;

import bg.softuni.dictionaryapp.model.entity.enums.LanguageName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "languages")
@Getter
@Setter
@NoArgsConstructor
public class Language extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private LanguageName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language", targetEntity = Word.class)
    private List<Word> words;

    public Language(LanguageName name) {
        this.name = name;
    }
}
