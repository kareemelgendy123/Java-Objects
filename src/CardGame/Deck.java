/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

/**
 *
 * @author Kareem
 */

public class Deck {

    // instance variables
    private Card[] cards;
    private int numCards;
    private boolean isShuffled;

    public Deck() {
        reset();
    }

    public void shuffle() {
        //Fischer-Yates Shuffle algorithm
        for (int i = 0; i < numCards; i++) {
            //generate random spot to swap with
            int spot = (int) (Math.random() * (numCards - i) + i);
            // swap cards
            Card temp = cards[i];
            cards[i] = cards[spot];
            cards[spot] = temp;
        }
        // set shuffled to true
        isShuffled = true;
    }

    public boolean isShuffled() {
        return this.isShuffled;
    }

    public int getNumberCardsLeft() {
        return this.numCards;
    }

    public Card dealCard() {
        this.numCards--;
        // deal out a card
        return this.cards[this.numCards];
    }

    public void reset() {
        this.numCards = 52;
        this.isShuffled = false;

        this.cards = new Card[52];
        // put cards into the deck
        int i = 0;
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 0; suit < 4; suit++) {
                Card c = new Card(rank, suit);
                this.cards[i] = c;
                i++;
            }
        }
    }
    
    public void printDeck(){
        for(int i = numCards-1; i >= 0; i--){
            System.out.println(cards[i]);
        }
    }
}    
