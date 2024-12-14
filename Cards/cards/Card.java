package cards;

public class Card {
    private String suit; // Масть
    private String rank; // Ранг

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    // Геттеры для масти и ранга
    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
}

