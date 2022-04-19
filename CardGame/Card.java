package CardGame;

public class Card {
    public enum Suits {
        Clubs,
        Diamonds,
        Hearts,
        Spades
    }
    private Suits suit;
    private int rank;

    public Card(Suits suit, int rank) {
      if(rank < 1 || rank > 13) {
          System.out.println("Invalid Rank");
          throw new IllegalArgumentException("Rank must be between 1 ans 13");
      }
      try {
          this.suit = suit;
      } catch (IllegalArgumentException ex) {
          throw new IllegalArgumentException("Invalid Suit");
      }
      this.rank = rank;

    }

    public String toString() {
        switch (this.rank) {
            case 1:
                return String.format("%s Ace", getSuitUnicodeSymbol(this.suit));
            case 11:
                return String.format("%s Jack", getSuitUnicodeSymbol(this.suit));
            case 12:
                return String.format("%s Queen", getSuitUnicodeSymbol(this.suit));
            case 13:
                return String.format("%s King", getSuitUnicodeSymbol(this.suit));
            default:
                return String.format("%s %d", getSuitUnicodeSymbol(this.suit), this.rank);
        }
    }
    private String getSuitUnicodeSymbol(Suits suit) {
        switch (this.suit) {
            case Clubs:
                return "\u2663";
            case Diamonds:
                return "\u2666";
            case Hearts:
                return "\u2665";
            case Spades:
                return "\u2660";
            default:
                return "";

        }
    }
    public boolean isBlack(){
        if(this.suit == Suits.Clubs || this.suit == Suits.Spades) {
            return true;
        }
        return false;
    }
    public int getRank() {
        return this.rank;
    }

}
