import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    ArrayList<Player> players;
    HashMap<Player, Integer> results;
    Deck deck;
    ArrayList<Player> winners;

    public Game(ArrayList<Player> players) {
        this.deck = new Deck();
        this.players = players;
        this.results = new HashMap<>();
        this.winners = new ArrayList<>();
    }

    public void prepareDeck() {
        this.deck.populateDeck();
        this.deck.shuffleDeck();
    }

    public void dealCard(int numberOfCards) {
        for(Player player : players) {
            for (int i = 0; i < numberOfCards; i++) {
                Card card = deck.removeCard();
                player.addCard(card);
            }
        }
    }

    public void determineWinners() { // Create a hash to handle draws - push player to it
        for(Player player : players) {
            if(winners.size() == 0) {
                winners.add(player);
            } else if (winners.get(0).handValue() < player.handValue()) {
                winners.clear();
                winners.add(player);
            } else if (winners.get(0).handValue() == player.handValue()) {
                winners.add(player);
            }
        }
    }

    public void printPlayers() {
        for(Player player : players) {
            System.out.println("\nPlayer: " + player.getName() + " \nPoints: " + player.handValue() + "\nCards: " + player.getAllCards());
        }
    }

    public void printWinners() {
        if (winners.size() == 1) {
            Player winner = winners.get(0);
            System.out.println ("\nResult: " + winner.getName() + " wins with " + winner.handValue() + " points.");
        } else {
            System.out.println("\nResult: It's a draw");
        }
    }




}
