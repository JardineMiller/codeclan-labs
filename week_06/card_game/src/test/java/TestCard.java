import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCard {
    Card card;

    @Before
    public void before() {
        card = new Card(CardSuit.SPADES, CardValue.ACE);
    }

    @Test
    public void hasValue() {
        assertEquals(CardValue.ACE, card.getValue());
    }

    @Test
    public void hasSuit() {
        assertEquals(CardSuit.SPADES, card.getSuit());
    }

}
