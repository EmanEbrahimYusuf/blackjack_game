/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author dell
 */
public class Card {
    private int suit;
    private int rank;
    private int value;
    public Card(int s,int r,int v){
        suit=s;
        rank=r;
        value=v;
    }
    public Card(){

    }
    public Card(Card c){
        
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
}
