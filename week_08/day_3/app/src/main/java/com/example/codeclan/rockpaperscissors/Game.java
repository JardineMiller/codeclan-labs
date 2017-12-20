package com.example.codeclan.rockpaperscissors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by Green on 20/12/2017.
 */

public class Game {

    private HashMap<String, String> results;
    private ArrayList<String> allMoves;
    private String computerMove;
    private String playerMove;
    private Random rand;


    public Game(String playerMove) {
        Random rand = new Random();
        this.playerMove = playerMove;
        this.results = new HashMap<>();
        this.results.put("scissors", "paper");
        this.results.put("paper", "rock");
        this.results.put("rock", "scissors");
        this.allMoves = new ArrayList<>(results.keySet());
        this.computerMove = allMoves.get(rand.nextInt(allMoves.size()));
    }

    public ArrayList<String> getAllMoves() {
        return allMoves;
    }

    public String getComputerMove() {
        return computerMove;
    }

    public String getPlayerMove() {
        return playerMove;
    }

    private boolean lose() {
        return (results.get(getComputerMove()).equals(getPlayerMove()));
    }

    private boolean win() {
        return (results.get(getPlayerMove()).equals(getComputerMove()));
    }

    public String getResult() {
        if (win()) {
            return "win";
        }
        if (lose()) {
            return "lose";
        }
        return "draw";
    }

    public void setComputerMove(String computerMove) {
        this.computerMove = computerMove;
    }

    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }

}


