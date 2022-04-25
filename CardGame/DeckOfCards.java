package CardGame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DeckOfCards {
    public enum State {
        underside,
        face,
        unfolded,
    }
    private ArrayList<Card> deck = new ArrayList<Card>();
    private State deckState = State.underside;

    // Constructors
    public DeckOfCards() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14 ; j++) {
                Card card = new Card(Card.Suits.valueOf(suits[i]), j); //Instantiate a Card
                this.addCard(card); //Adding card to the Deck
            }
        }
    }
    public DeckOfCards(DeckOfCards oldDeck) {
        if(oldDeck != null) {
            this.deckState = oldDeck.deckState;
            this.deck = oldDeck.getDeck();
        }
    }
    public DeckOfCards(Card card){
        this.addCard(card);
    }

    public DeckOfCards(String card) {
        int rank;
        //A card string is in the format "Symbol Level" the symbol is the first char
        char symbol = card.charAt(0);
        String level = card.split(" ")[1];
        //The Level is Ace, Jack, Queen, King or numbers from 2 to 10
        switch (level) {
            case "Ace":
                rank  = 1;
                break;
            case "Jack":
                rank  = 11;
                break;
            case "Queen":
                rank  = 12;
                break;
            case "King":
                rank  = 13;
                break;
            default:
                try {
                rank = Integer.parseInt(level);
                if(rank > 10 || rank < 2) {
                    throw new IllegalArgumentException("Invalid rank");
                }} catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid rank");
                }
        }
        Card.Suits suit;
        switch (symbol) {
            case '\u2666':
                suit = Card.Suits.Diamonds;
                break;
            case '\u2665':
                suit = Card.Suits.Hearts;
                break;
            case '\u2660':
                suit = Card.Suits.Spades;
                break;
            case '♣':
                suit = Card.Suits.Clubs;
            default:
                throw new IllegalArgumentException("Invalid symbol");
        }
        this.addCard(new Card(suit, rank));
    }


    public void addCard(Card card) {
        this.deck.add(card);
    }


    public String toString() {
        String result = "";
        switch (deckState) {
            case face -> result = this.deck.get(0).toString();
            case unfolded -> {
                for (Card card: this.deck) {
                    result = result + card.toString() + " ";
                }
            }
        }
        return result;
    }
    public Card pickRandom() {
        try {
            int randomNum = ThreadLocalRandom.current().nextInt(0, this.deck.size());
            Card picked = this.deck.get(randomNum);
            this.deck.remove(randomNum);
            return picked;
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("You can not pick a card from an empty deck");
        }

    }
    public int countBlack() {
        int total = 0;
        for (Card card: this.deck) {
            //if(card.isBlack()) {
                switch (card.getRank()) {
                case 11, 12, 13:
                    total += 10;
                    break;
                case 1:
                    total += 11;
                    break;
                default:
                    total += card.getRank();
                }
            //}
        }
        return total;
    }
    public ArrayList getDeck() { // dev function
        return this.deck;
    }

    public void setDeckState(State newState){
        this.deckState = newState;
    }

    public void shuffleDeck() {
        for (int i = 0; i < this.deck.size() * 3; i++) {
            deck.add(this.pickRandom());
        }
    }
    //Log purpose, to see what's inside the deck
    public void printDeck() {
        for (Card card:deck){
            System.out.println(card.toString());
        }
    }

}
