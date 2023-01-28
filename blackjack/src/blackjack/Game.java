/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
//attributes

    Player[] p=new Player[4];
    Card []c =new Card[52];
    int counter_of_cards_draw=0;
    int high_score=0;
    int randomChoice;
    GUI gui = new GUI();
//constractor

    public  Game(){
        generate_Card();
        set_Info();
    }
//----------------------------------------------------------------------------------//
//generate 52 cards for deck from index 0 to 51

    public Card [] generate_Card() {
        int x=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (j >= 10) {
                    c[x] = new Card(i, j, 10);
                }
                else {
                    c[x] = new Card(i, j, j + 1);
                }
                x++;
            }
        }
    return c;
    }
//----------------------------------------------------------------------------------//
//draw random card from 52 cards
    public Card draw_Card() {
       while (true) {
           Random rand=new Random();
            randomChoice=rand.nextInt(52);
           if(c[randomChoice]!=null) {
               counter_of_cards_draw++;
               return c[randomChoice];
           }
       }
    }
//----------------------------------------------------------------------------------//
//set information of 4 player (name) and draw 2 card randomly for each player
    public void set_Info() {
//set information of 3 player (name) and initilization 4th player with name dealer
       Scanner input =new Scanner(System.in);
       System.out.printf("%s","please, enter the first player name: ");
       p[0]=new Player(input.next());
       System.out.printf("%s","please, enter the second player name: ");
       p[1]=new Player(input.next());
       System.out.printf("%s","please, enter the third player name: ");
       p[2]=new Player(input.next());
       p[3]=new Player("dealer");
//draw 2 card for each player by default randomly and null this cards
//first player (1st card)
       p[0].cp[0]=draw_Card();
       Player.p1_counter++;
       update_Score(0,p[0].cp[0].getValue());
       c[randomChoice]=null;
//first player (2nd card)
       p[0].cp[1]=draw_Card();
       Player.p1_counter++;
       update_Score(0,p[0].cp[1].getValue());
       c[randomChoice]=null;
//second player (1st card)
       p[1].cp[0]=draw_Card();
       Player.p2_counter++;
       update_Score(1,p[1].cp[0].getValue());
       c[randomChoice]=null;
//second player (2nd card)
       p[1].cp[1]=draw_Card();
       Player.p2_counter++;
       update_Score(1,p[1].cp[1].getValue());
       c[randomChoice]=null;
//third player (1st card)
       p[2].cp[0]=draw_Card();
       Player.p3_counter++;
       update_Score(2,p[2].cp[0].getValue());
       c[randomChoice]=null;
//third player (2nd card)
       p[2].cp[1]=draw_Card();
       Player.p3_counter++;
       update_Score(2,p[2].cp[1].getValue());
       c[randomChoice]=null;
//fourth player (1st card)
       p[3].cp[0]=draw_Card();
       Player.p4_counter++;
       update_Score(3,p[3].cp[0].getValue());
       c[randomChoice]=null;
//fourth player(2nd card)
       p[3].cp[1]=draw_Card();
       Player.p4_counter++;
       update_Score(3,p[3].cp[1].getValue());
       c[randomChoice] = null;
    }
//----------------------------------------------------------------------------------//
//update score for each player after draw card
    public void update_Score(int index,int val) {
       p[index].setScore(val+p[index].getScore());
    }
//----------------------------------------------------------------------------------//
    public boolean hand_hit(){
       boolean p1_hand=false;
       boolean p2_hand=false;
       boolean p3_hand=false;
       Scanner input =new Scanner(System.in);
//hit or hand for each player gardually
       while ( p1_hand == false){
//hit or hand for 1st player
           System.out.println("Player1 --> 0 : Hit");
           System.out.println("Player1 --> 1 : Hand");
           if(input.nextInt()==0){
             System.out.println("---------------------------------------------------------");
//check if 1st player cards bounds and draw card
              if(Player.p1_counter<11){
                 p[0].cp[Player.p1_counter] = draw_Card();
                 update_Score(0, p[0].cp[Player.p1_counter].getValue());
                 gui.updatePlayerHand(p[0].cp[Player.p1_counter], 0);
                 c[randomChoice]=null;
                 Player.p1_counter++;
             }
//check if 1st player BUSTED (LOSE) or no
              if(p[0].getScore()>21){
                 System.out.printf("%s \n",p[0].getName()+" (BUSTED).");
                 break;
             }
//check if 1st player BLACKJAC (win) or no
             if(p[0].getScore()==21){
                 break;
             }
         }
         else{
             p1_hand=true;
         }
       }
//----------------------------------------------------------------------------------//
//update high score attribute
       if (p[0].getScore() > high_score && p[0].getScore() <= 21){
        high_score = p[0].getScore();
       }
//----------------------------------------------------------------------------------//
       while (p[1].getScore()<21 && p2_hand == false && Player.p2_counter<11){
//hit or hand for 2nd player
            System.out.println("Player2 --> 0 : Hit");
            System.out.println("Player2 --> 1 : Hand");
            if(input.nextInt()==0){
            System.out.println("---------------------------------------------------------");
            p[1].cp[Player.p2_counter]=draw_Card();
            update_Score(1,p[1].cp[Player.p2_counter].getValue());
            gui.updatePlayerHand(p[1].cp[Player.p2_counter], 1);
            c[randomChoice]=null;
            Player.p2_counter++;
//check if 2nd player BUSTED (LOSE) or no
            if(p[1].getScore()>21){
                System.out.printf("%s \n",p[1].getName()+" (BUSTED).");
                break;
            }
//check if 1st player BLACKJAC (win) or no
            if(p[1].getScore()==21){
                break;
            }
        }
        else{
            p2_hand=true;
        }
       }
//----------------------------------------------------------------------------------//
//update high score attribute
       if(p[1].getScore()>high_score&&p[1].getScore()<=21){
        high_score=p[1].getScore();
        }
//----------------------------------------------------------------------------------//
        while ( p3_hand == false && Player.p3_counter<11){
        //hit or hand for 2nd player
            System.out.println("Player3 --> 0 : Hit");
            System.out.println("Player3 --> 1 : Hand");
            if(input.nextInt()==0){
               System.out.println("---------------------------------------------------------");
               p[2].cp[Player.p3_counter]=draw_Card();
                update_Score(2,p[2].cp[Player.p3_counter].getValue());
                gui.updatePlayerHand(p[2].cp[Player.p3_counter], 2);
                c[randomChoice]=null;
                Player.p3_counter++;
//check if 3rd player BUSTED (LOSE) or no
                 if(p[2].getScore()>21){
                   System.out.printf("%s \n",p[2].getName()+" (BUSTED).");
                   break;
                 }
//check if 1st player BLACKJAC (win) or no
                if(p[2].getScore()==21) {
                    break;
                }
            }
                else{
                   p3_hand=true;
                }
    }
//----------------------------------------------------------------------------------//
//update high score attribute
    if(p[2].getScore()>high_score&&p[2].getScore()<=21){
        high_score=p[2].getScore();
    }
//----------------------------------------------------------------------------------//
//4th player hit
    while (Player.p4_counter < 11 && p[3].getScore()<high_score){
            p[3].cp[Player.p4_counter] = draw_Card();
            update_Score(3, p[3].cp[Player.p4_counter].getValue());
            c[randomChoice]=null;
            gui.updateDealerHand(p[3].cp[Player.p4_counter], notNull());
            Player.p4_counter++;
    }
//----------------------------------------------------------------------------------//
//check if 4th player BUSTED (LOSE) or no
        if(p[3].getScore()>21){
            System.out.printf("%s \n",p[3].getName()+" (BUSTED).");
        }
//----------------------------------------------------------------------------------//
//update high score attribute
        if(p[3].getScore()>high_score&&p[3].getScore()<=21) {
            high_score=p[3].getScore();
        }
//----------------------------------------------------------------------------------//
//call checkpush fun
         if(checkPush()) {
            System.out.printf("%s","(*--GAME PUSH--* ) whith score := "+high_score);
            return true;
         }
//----------------------------------------------------------------------------------//
       else {checkwinner();}
     return false;
    }
//----------------------------------------------------------------------------------//
//check who is win the game
    public void checkwinner(){
        for (int i=0;i<4;i++){
            if(p[i].getScore()==high_score && high_score <21 || p[i].getScore()==21 ) {
                System.out.printf("%s \n",p[i].getName()+" IS WINNER WITH HIGHE SCORE := "+high_score);
            }
        }
    }
//----------------------------------------------------------------------------------//
//set not null cards for Gui
    public Card[] notNull(){
        int v=0;
        Card []not_null_cards =new Card[52-counter_of_cards_draw+1];
        for(int i=0;i<52;i++){
            if(c[i]!=null){
                not_null_cards[v]=c[i];
                v++;
            }
        }
        return not_null_cards;
    }
//----------------------------------------------------------------------------------//
//check for pushing in game
    public boolean checkPush(){
        int check_push=0;
        for(int i=0;i<4;i++){
            if(p[i].getScore()==high_score && high_score<21){
                check_push++;
            }
        }
        if(check_push> 1 ){
            return true;
        }
        else{
            return false;
        }
    }
//----------------------------------------------------------------------------------//
}