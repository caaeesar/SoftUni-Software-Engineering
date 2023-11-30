package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "games")
public class Game extends BaseEntity {

    @OneToOne
    private Team homeTeam;
    @OneToOne
    private Team awayTeam;
    @Column(name = "home_goals")
    private int homeGoals;
    @Column(name = "away_goals")
    private int awayGoals;
    @Column(name = "date_time_of_game")
    private LocalDate dateTimeOfGame;
    @Column(name = "home_team_win_bet_rate")
    private double homeTeamWinBetRate;
    @Column(name = "away_team_win_bet_rate")
    private double awayTeamWinBetRate;
    @Column(name = "draw_game_bet_rate")
    private double drawGameBetRate;
    @ManyToOne
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    private Round round;
    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Competition competition;

}
