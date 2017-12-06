import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestGame {
    Game game;
    Player player1;
    Player player2;
    ArrayList<Player> players;

    @Before
    public void before() {
        player1 = new Player("Quentin");
        player2 = new Player("Gwendaline");
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        game = new Game(players);
    }

    @Test
    public void testDealOneCard() {
        game.prepareDeck();
        game.dealCard(1);
        assertEquals(1, player1.handCount());
        assertEquals(1, player2.handCount());
        assertEquals(50, game.deck.cardCount());
    }

    @Test
    public void testDealMultipleCard() {
        game.prepareDeck();
        game.dealCard(3);
        assertEquals(3, player1.handCount());
        assertEquals(3, player2.handCount());
        assertEquals(46, game.deck.cardCount());
    }
    
}
