package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "bets")
public class Bet extends BaseEntity {

    private BigDecimal money = BigDecimal.ZERO;
    @Column(name = "date_time_of_bet")
    private LocalDate dateTimeOfBet;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Userr user;
}
