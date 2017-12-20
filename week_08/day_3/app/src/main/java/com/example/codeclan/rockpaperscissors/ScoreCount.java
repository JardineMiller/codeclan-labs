package com.example.codeclan.rockpaperscissors;

/**
 * Created by jardine on 20/12/2017.
 */

public class ScoreCount {
    private Integer playerScore;
    private Integer computerScore;

    public ScoreCount() {
        this.playerScore = 0;
        this.computerScore = 0;
    }

    public void increaseScore(String result) {
        if (result.equals("win")) {
            this.playerScore ++;
        }
        if (result.equals("lose")) {
            this.computerScore ++;
        }
    }

    public String getPlayerScore() {
        return Integer.toString(this.playerScore);
    }

    public String getComputerScore() {
        return Integer.toString(this.computerScore);
    }

}
