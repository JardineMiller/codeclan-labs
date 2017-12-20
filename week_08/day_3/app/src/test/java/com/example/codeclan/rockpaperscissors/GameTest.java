package com.example.codeclan.rockpaperscissors;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Green on 20/12/2017.
 */

public class GameTest {
    Game game;

    @Before
    public void before() {
        game = new Game("rock");
    }

    @Test
    public void playerHasHand() {
        assertEquals("rock", game.getPlayerMove());
    }

    @Test
    public void gameHasResult() {
        assertNotNull(game.getResult());
    }

    @Test
    public void computerHasHand() {
        assertNotNull(game.getComputerMove());
    }

    @Test
    public void gameHasAllMovies() {
        assertEquals(3, game.getAllMoves().size());
    }

    @Test
    public void rockBeatsScissors() {
        game.setComputerMove("scissors");
        assertEquals("win", game.getResult());
    }

    @Test
    public void rockLosesPaper() {
        game.setComputerMove("paper");
        assertEquals("lose", game.getResult());
    }

    @Test
    public void rockDrawsRock() {
        game.setComputerMove("rock");
        assertEquals("draw", game.getResult());
    }

    @Test
    public void paperDrawsPaper() {
        game.setPlayerMove("paper");
        game.setComputerMove("paper");
        assertEquals("draw", game.getResult());
    }

    @Test
    public void paperBeatsRock() {
        game.setComputerMove("paper");
        assertEquals("lose", game.getResult());
    }

    @Test
    public void paperLosesScissors() {
        game.setComputerMove("scissors");
        game.setPlayerMove("paper");
        assertEquals("lose", game.getResult());
    }

    @Test
    public void scissorsDrawsScissors() {
        game.setPlayerMove("scissors");
        game.setComputerMove("scissors");
        assertEquals("draw", game.getResult());
    }

    @Test
    public void scissorsBeatsPaper() {
        game.setPlayerMove("scissors");
        game.setComputerMove("paper");
        assertEquals("win", game.getResult());
    }

    @Test
    public void scissorsLosesRock() {
        game.setComputerMove("rock");
        game.setPlayerMove("scissors");
        assertEquals("lose", game.getResult());
    }

    @Test
    public void gameCanDraw() {
        game.setComputerMove("rock");
        assertEquals("draw", game.getResult());
    }


}
