package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "deposits")
@Setter
@Getter
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "deposit_group", length = 20)
    private String group;
    @Column(name = "deposit_start_date", columnDefinition = "DATETIME")
    private LocalDate startDate;
    @Column(name = "deposit_amount", precision = 4, scale = 2)
    private BigDecimal amount;
    @Column(name = "deposit_interest", precision = 4, scale = 2)
    private BigDecimal interest;
    @Column(name = "deposit_charge", precision = 4, scale = 2)
    private BigDecimal charge;
    @Column(name = "deposit_expiration_date", columnDefinition = "DATETIME")
    private LocalDate expirationDate;
    @Column(name = "is_deposit_expired", columnDefinition = "TINYINT(1)")
    private boolean isExpired;

}
