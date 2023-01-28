/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
public class Player {
//attributes
private String Name;
private int Score=0;
static int  p1_counter=0,p2_counter=0,p3_counter=0,p4_counter=0;
Card []cp=new Card[11];
//constractors
    public Player(String n)
    {
        Name=n;
    }
    public Player() { }
//methods
    public int getScore(){
    return Score;
    }
    public void setScore(int score) {
        this.Score = score;
    }
    public String getName() {
        return Name;
    }
}
