package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "teams")
public class Team extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "BLOB")
    private byte[] logo;

    private String initials;

    @ManyToOne
    @JoinColumn(name = "primary_kit_color", referencedColumnName = "id")
    private Color primaryColor;

    @ManyToOne
    @JoinColumn(name = "secondary_kit_color", referencedColumnName = "id")
    private Color secondaryColor;

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town residentTown;

    private BigDecimal budget;

    @OneToMany(mappedBy = "team", targetEntity = Player.class)
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.budget = BigDecimal.ZERO;
    }

    public Team() {

    }
}
