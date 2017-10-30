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
public class Card {
    // suit constants
    public static final int CLUBS = 0;
    public static final int DIAMONDS = 1;
    public static final int SPADES = 2;
    public static final int HEARTS = 3;
    
    // instance variables
    private int rank;
    private int suit;
    
    // constructor
    /**
     * The constructor for a single playing card
     * @param rank the rank of the card (1-13)
     * @param suit the suit of the card
     */
    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * get the suit of the card
     * @return the suit of the card
     */
    public int getSuit(){
        return this.suit;
    }
    
    /**
     * gets the rank of the card
     * @return the rank of the card
     */
    public int getRank(){
        return this.rank;
    }
    
    /**
     * Determines if this card is bigger than another card
     * @param c the card to check against
     * @return true if the card is bigger than Card c
     */
    public boolean isBigger(Card c){
        // is this card bigger than the one passed in
        if(this.rank > c.rank){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    /**
     * Pretty version of a card
     */
    public String toString(){
        String output = "";
        
        // adding the rank to the string
        if(this.rank == 1){
            output += "Ace";
        }else if(this.rank <= 10){
            output += this.rank;
        }else if(this.rank == 11){
            output += "Jack";
        }else if(this.rank == 12){
            output += "Queen";
        }else if(this.rank == 13){
            output += "King";
        }
        
        output += " of ";
        // format the suit
        if(this.suit == CLUBS){
            output += "\u2663";
        }else if(this.suit == DIAMONDS){
            output += "\u2662";
        }else if(this.suit == SPADES){
            output += "\u2660";
        }else{
            output += "\u2661";
        }
        return output;
    }
}
