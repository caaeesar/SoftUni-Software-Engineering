package bg.softuni.likebookapp.model.entity;

import bg.softuni.likebookapp.model.entity.enums.MoodType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "moods")
@Getter
@Setter
@NoArgsConstructor
public class Mood extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private MoodType name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Mood(MoodType name) {
        this.name = name;
    }
}
