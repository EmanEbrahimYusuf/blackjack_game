/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;
/**
 *
 * @author dell
 */
public class Blackjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI();
        Game g = new Game();
        
        try (Scanner input = new Scanner(System.in)) {
            String n1=input.next();
            String n2=input.next();
            String n3=input.next();
            String n4=input.next();
            
            Player p1=new Player(n1);
            Player p2=new Player(n2);
            Player p3=new Player(n3);
            Player p4=new Player(n4);
            
            gui.runGUI( g.c, p1.c, p2.c, p3.c, p4.c );
        }
        
        
    }
    
}
