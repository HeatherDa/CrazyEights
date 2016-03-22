package com.Heather;

import java.util.LinkedList;

/**
 * Created by cryst on 3/14/2016.
 */
public class Player {
    //Player's hand and error testing
    private LinkedList<Card> hand;

    Player(String name){
        this.hand=new LinkedList<>();

    }


    public void setHand(Card c) {
        hand.add(c);
    }

    public Card nextcard(){
        Card play = null;

        return play;
    }

    public void writeHand(){
        for (Card card:hand){
            System.out.println(card.getName());
        }
    }
}
