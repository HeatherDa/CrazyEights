package com.Heather;
import java.util.*;
public class CrazyEights {

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        int dealcards = 5;//number of cards dealt to each player
        Deck deck = new Deck();  //initialize deck
        System.out.println("What is your name?");
        String playname = scan.nextLine();
        Player player = new Player(playname);
        Computer computer = new Computer();
        for (int i = 0; i > 6; i++) {  //initialize hands
            player.setHand(deck.dealcard());
            computer.setHand(deck.dealcard());
        }
        //initialize last card useing setLastcard(dealcard())
        //if size.computerhand!=0 && size.playerhand!=0
        //player play card
        //setLastcard(getPlayercard())
        //if size.playerhand ==0
        //sout player wins
        //else
        //computer play card
        //setLastcard(getComputercard())
        //if size.computerhand==0
        //sout computer wins

    }
}