package CardGame;

public class MainCardGame {

    public static void main(String[] args)  {
        Card card = new Card(Card.Suits.Clubs, 1);

        DeckOfCards deck1 = new DeckOfCards(); // 52 cards
        DeckOfCards deck2 = new DeckOfCards((DeckOfCards) null); // 0 card
        DeckOfCards deck3 = new DeckOfCards(card); // 1 card
        DeckOfCards deck4 = new DeckOfCards("♦ Jack"); // 1 card : Jack of Diamond

        //By default, no card is visible in the deck
        System.out.println(deck1.toString());
        deck1.setDeckState(DeckOfCards.State.face); // Only one card is visible
        System.out.println(deck1.toString());
        deck1.setDeckState(DeckOfCards.State.unfolded); //All card are visible
        System.out.println(deck1.toString());

        //Let's take a card
        Card theCard = deck1.pickRandom();
        System.out.println(theCard.toString());
        System.out.println(deck1.toString());
        //Let's put back the card
        deck1.addCard(theCard);
        System.out.println(deck1.toString());

        //Let's shuffle the deck (not asked, useless, but it's fun and easy to do)
        deck1.shuffleDeck();
        System.out.println(deck1.toString());

        // Let's count the different black value in different decks : We take 1 = 11 points
        System.out.println(deck1.countBlack());
        System.out.println(deck2.countBlack());
        System.out.println(deck3.countBlack());
        System.out.println(deck4.countBlack());

        // Sensible stuff :
        try {
            deck2.pickRandom();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
        DeckOfCards deck5 = new DeckOfCards("Invalid Jack"); // Invalid string
        deck5.setDeckState(DeckOfCards.State.unfolded); //All card are visible
        System.out.println(deck5.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
