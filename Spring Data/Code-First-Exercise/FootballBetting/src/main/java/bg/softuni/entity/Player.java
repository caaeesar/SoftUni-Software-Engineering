package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "players")
public class Player extends BaseEntity {

    private String name;
    @Column(name = "squad_number")
    private int squadNumber;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    @Column(columnDefinition = "TINYINT(1)")
    private boolean isInjured;

}
