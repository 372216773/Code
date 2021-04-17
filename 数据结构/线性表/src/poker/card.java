package poker;

import java.util.Objects;

public class card {
    private String suit;
    private int rank;

    public card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "[" + suit + rank +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof card)) return false;
        card card = (card) o;
        return rank == card.rank ;
    }

}
