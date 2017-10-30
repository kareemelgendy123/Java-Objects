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

public class Player {
    private ArrayList<Card> hand;
    private String name;
    private int numCards;
    
    public Player(String name){
        this.name = name;
        this.numCards = 0;
        this.hand = new ArrayList<>();
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getNumCards(){
        return this.numCards;
    }
    
    public void takeCard(Card c){
        this.hand.add(c);
        this.numCards++;
    }
    
    public Card playCard(){
        this.numCards--;
        Card c = this.hand.remove(0);
        return c;
    }
    
    public Card[] get3Cards(){
        Card[] cards = new Card[3];
        for(int i = 0; i < 3; i++){
            cards[i] = playCard();
        }
        return cards;
    }
    
}
