import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public String getAllCards() {
        String cards = "";
        for(Card card : hand) {
            cards += "\n" + card.prettyName();
        }
        return cards;
    }

    public int handCount() {
        return this.hand.size();
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public int handValue() {
        int total = 0;
        for(Card card : hand) {
            total += card.getCardValue();
        }
        return total;
    }


}
