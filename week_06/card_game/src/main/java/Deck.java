import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public int cardCount() {
        return this.cards.size();
    }

    public void populateDeck() {
        for(CardSuit suit : CardSuit.values()) {
            for(CardValue value : CardValue.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card removeCard() {
        return this.cards.remove(0);
    }
}
