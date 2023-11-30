package WorkingWithAbstraction.exercises.CardsWithPower;

public class Card {

    enum Rank {
        ACE(14),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        private int power;

        Rank(int power) {
            this.power = power;
        }
    }

    enum Suit {
        CLUBS(0),
        DIAMONDS(13),
        HEARTS(26),
        SPADES(39);

        private int power;

         Suit(int power) {
            this.power = power;
        }
    }

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int calculatePower() {
        return this.suit.power + this.rank.power;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank.name(), this.suit.name(), this.calculatePower());
    }
}
