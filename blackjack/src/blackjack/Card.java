/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
public class Card {
private final int suit;
private final int rank;
private final int value;

//constractors
    public Card(int s,int r,int v) {
        this.suit=s;
        this.rank=r;
        this.value=v;
    }
    public Card( Card C) {
       suit=C.suit;
       value=C.value;
       rank=C.rank;
    }
//methods
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






























/**
 *
 * @author dell

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

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRank(int rank) {
        this.rank = rank;
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
*/