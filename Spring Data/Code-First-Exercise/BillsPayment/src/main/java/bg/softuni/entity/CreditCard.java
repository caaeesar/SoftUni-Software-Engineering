package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class CreditCard extends BillingDetail {

    private enum CardType {
        NORMAL,
        SILVER,
        GOLD
    }

    @Enumerated(EnumType.STRING)
    private CardType type;
    @Column(name = "expiration_month")
    private int expirationMonth;
    @Column(name = "expiration_year")
    private int expirationYear;

    public CreditCard() {

    }
    public CreditCard(int expirationMonth, int expirationYear) {
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }
}
