package CardGame2;

public class MainGain {
    public static void main(String[] args) {
        Card carteTest = new Card(Card.Ranks.ACE, Card.Suits.Clubs);
        Card carteTest2 = new Card(Card.Ranks.KING, Card.Suits.Hearts);

        //System.out.println(carteTest.toString());


        DeckOfCards deckTest = new DeckOfCards();

        System.out.println(deckTest.countBlack());
        System.out.println(deckTest.pickRandom().toString());
        System.out.println(deckTest.countBlack());

        DeckOfCards deckTest2 = new DeckOfCards(deckTest);
        System.out.println(deckTest2.countBlack());

        DeckOfCards deckTest3 = new DeckOfCards(carteTest);
        System.out.println(deckTest3.countBlack());

        try {
            DeckOfCards deckTest4 = new DeckOfCards("seven Clubs");
            System.out.println(deckTest4.countBlack());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }


    }

}
