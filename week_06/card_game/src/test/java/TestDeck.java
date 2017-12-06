import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeck {
    Deck deck;

    @Before
    public void before() {
        deck = new Deck();
    }

    @Test
    public void canCreateDeck() {
        assertEquals(0, deck.cardCount());
    }

    @Test
    public void canPopulateDeck() {
        deck.populateDeck();
        assertEquals(52, deck.cardCount());
    }

    @Test public void doesShuffle() {
        deck.populateDeck();
        deck.shuffleDeck();
        System.out.println(deck.removeCard().prettyName());
    }

    @Test
    public void dealsFirstCard() {
        deck.populateDeck();
        Card firstCard = new Card(CardSuit.values()[0], CardValue.values()[0]);
        assertEquals(firstCard.prettyName(), deck.removeCard().prettyName());
    }
}
