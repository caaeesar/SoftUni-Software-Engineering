package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "bet_games")
public class BetGame implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;
    @Id
    @ManyToOne
    @JoinColumn(name = "bet_id", referencedColumnName = "id")
    private Bet bet;
    @OneToOne
    @JoinColumn(name = "result_prediction", referencedColumnName = "id")
    private ResultPrediction resultPrediction;


}
