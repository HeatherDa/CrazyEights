package com.Heather;

import java.util.*;


/**
 * Created by cryst on 3/14/2016.
 */
public class Player {
    //Player's hand and error testing
    Scanner scan=new Scanner(System.in);
    private LinkedList<Card> hand;
    private String name;

    Player(String name){
        this.name=name;
        this.hand=new LinkedList<>();

    }
    public Card getPlay(Deck deck){
        Card play=null;
        LinkedList<Card>plays=playable(deck);
        Card last=deck.getLastcard();
        String name=last.getName();
        System.out.println("The top card is "+name+".");
        System.out.println("You have the following cards: ");
        for (int i=0; i<hand.size();i++){
            System.out.println(i+"\t"+hand.get(i));
        }
        System.out.println("To make a play, type the number in front of the card and hit enter.  Hit enter without typing to draw a card.");
        String next=scan.nextLine();
        if (next.equals("")){
            deck.dealcard();
        }else{
            Card choice=this.hand.get(Integer.parseInt(next));
            while(play==null) {
                if (plays.contains(choice)) {
                    play = choice;
                    this.hand.remove(choice);
                } else {
                    System.out.println("That is not a valid play.");
                    continue;
                }
            }
        }
        return play;
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

    public int getSize(){
        return hand.size();
    }
    public LinkedList<Card> getHand(){
        return this.hand;
    }
    public LinkedList<Card> playable(Deck deck){
        LinkedList<Card>playcards=new LinkedList<>();
        Card last=deck.getLastcard();
        int matchval=0;
        int matchsuit=0;
        int eight=0;
        ArrayList<Card> mval=new ArrayList<>();
        ArrayList<Card>msuit=new ArrayList<>();
        ArrayList<Card>eig=new ArrayList<>();
        for (Card card:hand) {
            if ((card.getValue().equals(last.getValue())) && (!last.getValue().equals("8"))) {
                matchval = matchval++;
                mval.add(card);
            }else if ((card.getSuit().equals(last.getSuit())) && (!card.getValue().equals("8"))) {
                matchsuit = matchsuit++;
                msuit.add(card);
            }else if (card.getValue().equals("8")) {
                eight = eight++;
                eig.add(card);
            }
        }

        return playcards;
    }
}
