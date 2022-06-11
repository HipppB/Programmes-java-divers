package CardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCardGame {

    public static void main(String[] args)  {
        playGame();

    }

    public static void playGame() {
        int numberOfWins = 0;
        int numberOfLoose = 0;


        String restart = "Y";
        Scanner scanner = new Scanner(System.in);

        while (restart.contentEquals("Y")) {
            System.out.printf("Let's start a round. %d game won, %d game lost", numberOfWins, numberOfLoose);
            if(startRound()) {
                numberOfWins += 1;
            } else {
                numberOfLoose += 1;

            };

            restart = "";
            while (!restart.contentEquals("Y") && !restart.contentEquals("N")) {
                System.out.println("Play again ? (Y/N)");
                restart = scanner.nextLine();
                if(!restart.contentEquals("Y") && !restart.contentEquals("N")) {
                    System.out.println("Invalid input");
                }
            }

        }


    }
    public static boolean startRound() {
        DeckOfCards deck = new DeckOfCards(); //Pile of card
        deck.shuffleDeck();

        DeckOfCards playersHand = new DeckOfCards((DeckOfCards) null); //player's hand
        DeckOfCards brokersHand = new DeckOfCards((DeckOfCards) null); //Broker's hand

        playersHand.setDeckState(DeckOfCards.State.unfolded);
        brokersHand.setDeckState(DeckOfCards.State.underside);


        playersHand.addCard(deck.pickCardOnTop());
        brokersHand.addCard(deck.pickCardOnTop());
        playersHand.addCard(deck.pickCardOnTop());
        brokersHand.addCard(deck.pickCardOnTop());

        brokersHand.setDeckState(DeckOfCards.State.face);

        System.out.println("Hand of the player");
        System.out.println(playersHand);

        System.out.println("Hand of the broker");
        System.out.println(brokersHand);

        Scanner scanner = new Scanner(System.in);
        String line = "";

        while (!line.contentEquals("N")) {
            line = "";
            while (!line.contentEquals("Y") && !line.contentEquals("N")) {
                System.out.println("Draw another card ? (Y/N)");
                line = scanner.nextLine();
                if(!line.contentEquals("Y") && !line.contentEquals("N")) {
                    System.out.println("Invalid input");
                }
            }
            if (line.contentEquals("Y")) {
                playersHand.addCard(deck.pickCardOnTop());
                System.out.println("Hand of the player");
                System.out.println(playersHand);
                if(playersHand.countBlack() >= 21) {
                    line = "N";
                }
            }

        }
        int playerValue = playersHand.countBlack();

        if(playerValue == 21) {
            //Player won
            System.out.println("Blackjack ! You won !");
            return true;
        } else if (playerValue > 21) {
            System.out.println("Too high ! You loose !");
            return false;
        } else {
            //Broker plays
            brokersHand.setDeckState(DeckOfCards.State.unfolded);
            System.out.println("Broker's hand : ");
            System.out.println(brokersHand);
            int brockervalue = brokersHand.countBlack();
            while (brockervalue < playerValue && brockervalue < 21) {
                System.out.printf("Broker value : %d%n", brockervalue );
                System.out.println("Broker picks a card");
                brokersHand.addCard(deck.pickCardOnTop());
                System.out.println("Broker's hand : ");
                System.out.println(brokersHand);
                brockervalue = brokersHand.countBlack();

            }
            if(brockervalue == 21) {
                System.out.println("Broker made a BlackJack, player looses !");
                return false;
            } else if (brockervalue < 21) {
                System.out.printf("Broker value : %d, Player value: %d : Broker wins, player looses %n", brockervalue, playerValue);
                return false;
            } else {
                System.out.printf("Broker value : %d, Broker looses, player wins ! %n", brockervalue);
                return true;
            }

        }




    }
}
