package com.example.codeclan.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RPSActivity extends AppCompatActivity {

    private Game game;
    private ScoreCount scoreCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);
        scoreCount = new ScoreCount();
    }

    public void showResults() {
        TextView playerSelect = findViewById(R.id.player_select);
        String playerSelectText = "You chose:\n" + game.getPlayerMove();
        playerSelect.setText(playerSelectText);

        TextView computerSelect = findViewById(R.id.computer_select);
        String compSelectText = "Computer chose:\n" + game.getComputerMove();
        computerSelect.setText(compSelectText);

        TextView resultText = findViewById(R.id.result_text);
        String resultString = "YOU " + game.getResult().toUpperCase();
        resultText.setText(resultString);
        scoreCount.increaseScore(game.getResult());

        TextView playerScore = findViewById(R.id.player_score);
        TextView computerScore = findViewById(R.id.computer_score);
        playerScore.setText(scoreCount.getPlayerScore());
        computerScore.setText(scoreCount.getComputerScore());
    }

    public void onRockButtonClick(View button) {
        Button rockButton = findViewById(R.id.rock);
        String rock = getResources().getResourceEntryName(rockButton.getId());
        game = new Game(rock);

        showResults();
    }

    public void onPaperButtonClick(View button) {
        Button paperButton = findViewById(R.id.paper);
        String paper = getResources().getResourceEntryName(paperButton.getId());
        game = new Game(paper);

        showResults();
    }

    public void onScissorsButtonClick(View button) {
        Button scissorsButton = findViewById(R.id.scissors);
        String scissors = getResources().getResourceEntryName(scissorsButton.getId());
        game = new Game(scissors);

        showResults();
    }
}
