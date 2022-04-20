package CardGame2;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DeckOfCards {
    enum States {
        underside,
        faceside,
        unfolded,
    }

    private ArrayList<Card> listOfCards = new ArrayList<>();
    public States deckState = States.faceside;

    public DeckOfCards() {
        System.out.println("Un deck a ete cree");
        for (Card.Suits suit : Card.Suits.values()) {
            for (Card.Ranks rank: Card.Ranks.values()) {
                Card carte = new Card(rank, suit);
                listOfCards.add(carte);
            }

        }
    }
    public DeckOfCards(DeckOfCards oldDeck) {
        System.out.println("Un deck a ete cree");
        if(oldDeck != null) {
            listOfCards = oldDeck.listOfCards;
            deckState = oldDeck.deckState;
        }
    }
    public DeckOfCards(Card card) {
        System.out.println("Un deck a ete cree avec une carte");
        this.listOfCards.add(card);

    }
    public DeckOfCards(String cardString) {
        try {
        System.out.println("Un deck a ete cree avec une carte string " + cardString);
        String[] elements = cardString.split(" ");
        Card newCard = new Card(Card.Ranks.valueOf(elements[0].toUpperCase()), Card.Suits.valueOf(elements[2]));
        this.listOfCards.add(newCard);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid string card");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid string card");
        }
    }

    public String toString(){
        String result = "";
        if(this.deckState == States.unfolded) {
            if(this.listOfCards.size() > 0) {
                for (Card carte : this.listOfCards) {
                    result = result + carte.toString() + ", ";
                }
            } else {
                result = "No card in the deck";
            }

        }
        if(this.deckState == States.faceside) {
            if(this.listOfCards.size() > 0) {
                result = this.listOfCards.get(0).toString();

            } else {
                result = "No card in the deck";
            }
        }
        if(this.deckState == States.underside) {
            result = "No visible card";
        }

     return result;
    }

    public Card pickRandom() {
        try {
            int randomNum = ThreadLocalRandom.current().nextInt(0, this.listOfCards.size());
            Card randomCard = this.listOfCards.get(randomNum);
            this.listOfCards.remove(randomNum);
            return randomCard;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No card in the deck");
        }
    }

    public int countBlack() {
        int result = 0;
        for (Card carte : this.listOfCards) {
            //Card.Suits cardSuit = carte.getSuits();
            //if(cardSuit == Card.Suits.Clubs  ||  cardSuit == Card.Suits.Spades){
                int cardValue = carte.getRank().getValue();
                result += cardValue;
            //}
        }

        return result;
    }
}
