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
public class Player {
    private String name;
    private int Score;
    Card []c=new Card[11];
    boolean win =false;
    boolean lose =false;
    public Player(String name) {  
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return Score;
    }
    
}
