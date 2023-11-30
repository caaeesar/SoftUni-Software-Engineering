package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "competitions")
public class Competition extends BaseEntity {

    private enum CompetitionTypes {
        local, national, international
    }

    private String name;
    @Enumerated(EnumType.STRING)
    private CompetitionTypes type;
}
