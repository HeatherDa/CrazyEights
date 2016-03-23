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
        Player pers = new Player(playname);
        Computer comp=new Computer();
        dealhand(pers, comp,deck);
        deck.setLastcard(deck.dealcard());//set first card

        while((comp.getSize()!=0)&&(pers.getSize()!=0)){//check for hands being empty
            deck.setLastcard(pers.getPlay(deck));
            System.out.println("last card played: "+(deck.getLastcard()).getName());
            if(pers.getSize()!=0) {//check for playerhand behing empty
                System.out.println("Computer hand: "+comp.getHand());
                deck.setLastcard(comp.getPlay(deck));
                System.out.println("Computer plays "+deck.getLastcard().getName());

                System.out.println("Player hand: "+pers.getHand());
            }
        }
        if (comp.getSize()==0){
            System.out.println("The Computer has won.");
        }else if (pers.getSize()==0){
            System.out.println("Congratulations, "+playname+".  You won!");
        }
    }
    public static void dealhand(Player player1, Computer player2, Deck deck){

        for (int i=0;i<5;i++){//deals 5 cards to each player
            player1.setHand(deck.dealcard());
            player2.setHand(deck.dealcard());
        }
    }
}