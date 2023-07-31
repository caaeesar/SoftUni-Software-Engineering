package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "player_statistics")
public class PlayerStatistics implements Serializable {

    // composite PK

    @Id
    @ManyToOne // many players -> one game
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @Id
    @ManyToOne // one game -> many players
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    @Column(name = "scored_goals")
    private int scoredGoals;
    private int assists;
    private int playedMinutes;

}
