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
@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity {

    private enum Prediction {
        Home_Team_Win,
        Draw_Game,
        Away_Team_Win
    }

    @Enumerated(EnumType.STRING)
    private Prediction prediction;

}
