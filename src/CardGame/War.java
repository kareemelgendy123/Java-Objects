/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

import java.util.ArrayList;


/**
 *
 * @author Kareem
 */

public class War {

    // Method for winner
    public static int winner(Card p1Card, Card p2Card) {
        // did a war happen?
        if (p1Card.getRank() == p2Card.getRank()) {
            System.out.println("WAR");
            return 0;
            // player1 wins
        } else if (p1Card.getRank() == 1 || (p1Card.isBigger(p2Card) && p2Card.getRank() != 1)) {
            System.out.println("Player 1 wins this round");
            return 1;
            // player 2 wins
        } else {
            System.out.println("Player 2 wins this round");
            return 2;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create Deck of cards
        Deck deck = new Deck();
        // create some players
        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");

        // shuffle deck and deal cards
        deck.shuffle();
        for (int i = 0; i < 52; i++) {
            // alternate card taking
            if (i % 2 == 0) {
                p1.takeCard(deck.dealCard());
            } else {
                p2.takeCard(deck.dealCard());
            }
        }

        // game time!
        // as long as players have cards
        while (p1.getNumCards() > 0
                && p2.getNumCards() > 0) {
            // player 1s card
            Card p1Card = p1.playCard();
            System.out.println("Player 1 plays " + p1Card);
            // player 2s card
            Card p2Card = p2.playCard();
            System.out.println("Player 2 plays " + p2Card);

            // who wins?
            int winner = winner(p1Card, p2Card);
            // did a war happen?
            if (winner == 0) {
                // create card pile for cards
                ArrayList<Card> pile = new ArrayList<>();

                // keep playing until someone wins
                while (winner == 0) {
                    // make sure players have enough cards
                    if(p1.getNumCards() < 4){
                        System.out.println("Player 1 ran out of cards for a war");
                        // p1 loses, p2 wins!
                        winner = 2;
                        // get rid of cards
                        while(p1.getNumCards() > 0){
                            p1.playCard();
                        }
                        break;
                    }else if( p2.getNumCards() < 4){
                        System.out.println("Player 2 ran out of cards for a war");
                        // p2 loses, p1 wins!
                        winner = 1;
                        // get rid of cards
                        while(p2.getNumCards() > 0){
                            p2.playCard();
                        }
                        break;
                    }
                    // declare war
                    System.out.println("WAR");
                    // add in already played cards
                    pile.add(p1Card);
                    pile.add(p2Card);
                    // draw 3 cards from 
                    // each player to add to pile
                    Card[] p1Cards = p1.get3Cards();
                    Card[] p2Cards = p2.get3Cards();
                    for (int i = 0; i < 3; i++) {
                        pile.add(p1Cards[i]);
                        pile.add(p2Cards[i]);
                    }
                    // new card for each player
                    p1Card = p1.playCard();
                    p2Card = p2.playCard();
                    System.out.println("Player 1 plays " + p1Card);
                    System.out.println("Player 2 plays " + p2Card);
                    winner = winner(p1Card, p2Card);
                }

                // war is over
                // add pile to victor!
                if (winner == 1) {
                    // for each card in the pile
                    for (Card aCard : pile) {
                        p1.takeCard(aCard);
                    }
                } else {
                    // for each card in the pile
                    for (Card aCard : pile) {
                        p2.takeCard(aCard);
                    }
                }
            }

            // player1 wins
            if (winner == 1) {
                // take both cards
                p1.takeCard(p2Card);
                p1.takeCard(p1Card);
                // player 2 wins
            } else {
                // take both cards
                p2.takeCard(p1Card);
                p2.takeCard(p2Card);
            }
            // space to seperate rounds
            System.out.println("P1:" + p1.getNumCards() + "   P2: " + p2.getNumCards());
            System.out.println("");
        }
        
        // player 1 wins!
        if(p1.getNumCards() > 0){
            System.out.println("Player 1 WINS!");
        // player 2 wins!
        }else{
            System.out.println("Player 2 WINS!");
        }
        
    }

}