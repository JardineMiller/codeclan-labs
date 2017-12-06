import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Player player1 = new Player("Quentin");
        Player player2 = new Player("Gwendaline");
        ArrayList players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        Game game = new Game(players);
        game.play(2);
    }
}
