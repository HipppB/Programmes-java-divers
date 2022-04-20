package CardGame2;

public class Card {

    enum Ranks {
        ACE(11, "Ace"),
        TWO(2, "two"),
        THREE(3, "three"),
        FOUR(4, "four"),
        FIVE(5, "five"),
        SIX(6, "six"),
        SEVEN(7, "seven"),
        EIGHT(8, "eight"),
        NINE(9, "nine"),
        TEN(10, "ten"),
        JACK(10, "Jack"),
        QUEEN(10, "Queen"),
        KING(10, "King");

        private String name;
        private int value;

        Ranks(int value, String name) {
            this.name = name;
            this.value = value;
        }
        public String getName() {
            return this.name;
        }
        public int getValue() {
            return this.value;
        }

    }
    enum Suits {
        Clubs,
        Diamonds,
        Hearts,
        Spades

    }


    private Ranks rank;
    private Suits suit;

    public Card(Ranks rankCard, Suits suitCard) {
        this.rank = rankCard;
        this.suit = suitCard;
    }

    public String toString(){
        //Ace of Spades
        String value = this.rank.name + " of " + this.suit;
        return value;
    }

    public Ranks getRank() {
        return rank;
    }
    public Suits getSuits() {
        return suit;
    }

}

