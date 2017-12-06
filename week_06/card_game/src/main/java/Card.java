public class Card {
    private CardSuit suit;
    private CardValue value;
    
    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public CardValue getValue() {
        return value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public String prettyName() {
        return value.toString() + " of "  + suit.toString();
    }

    public int getCardValue() {
        return this.value.getValue();
    }



}
