package com.Heather;

import java.util.*;

public class Computer{
    private LinkedList<Card> hand;

    //Computer's hand and decision mechanics
    Computer(){
        this.hand=new LinkedList<>();
    }

    public Card getPlay(Deck deck){
        Card last=deck.getLastcard();
        Card play=null;
        ArrayList<Card>mval=new ArrayList<>();//cards that match previous value and are not eight
        ArrayList<Card>msuit=new ArrayList<>();//cards that match previous suit and are not eight
        ArrayList<Card>eig=new ArrayList<>();//cards who's value is eight
        for (Card card:hand) {
            if ((card.getValue().equals(last.getValue())) && (!last.getValue().equals("8"))) {

                mval.add(card);
            }else if ((card.getSuit().equals(last.getSuit())) && (!card.getValue().equals("8"))) {

                msuit.add(card);
            }else if (card.getValue().equals("8")) {

                eig.add(card);
            }
        }
        if((mval.size()!=0)&&(msuit.size()!=0)) {
            //compare totalSuit for matching numbercard and totalSuit for last.getSuit()
            for (Card c : mval) {
                if (totalSuit(hand, c.getSuit()) > msuit.size()) {
                    play = c;
                    this.hand.remove(c);//remove the card from the hand after playing it
                } else if (totalSuit(hand, c.getSuit()) < msuit.size()) {
                    play = msuit.get(0);
                    this.hand.remove(c);//remove the card from the hand after playing it
                }
            }
        }else if((mval.size()==0)&&(msuit.size()!=0)){
            play = msuit.get(0);
            this.hand.remove(play);
        }else if((mval.size()>0)&&(msuit.size()==0)){
            play = mval.get(0);
            this.hand.remove(play);
        }else if ((mval.size()==0)&&(msuit.size()==0)&&(eig.size()>0)){//if the only move available is an eight
            play=eig.get(0);
            System.out.println("Computer plays "+play.getName());
            deck.setLastcard(play);
            deck.setNewsuit(biggestSuit(this.hand));//change suit of last card
            this.hand.remove(play);
            last=deck.getLastcard();

            String ANSI_black = "\u001B[30m";
            String ANSI_red = "\u001B[31m";
            String ANSI_reset_color = "\u001B[0m";
            String news;//holder for new suit
            if ((last.getSuit().equals(String.valueOf((char) 9824))) || last.getSuit().equals(String.valueOf((char) 9827))) {
                news=ANSI_black + last.getSuit() + ANSI_reset_color;
            } else {
                news=ANSI_red + last.getSuit() + ANSI_reset_color;
            }

            System.out.println("The new suit is "+news);
        }else if ((mval.size()==0)&&(msuit.size()==0)&&(eig.size()==0)){//if no moves available
            this.hand.add(deck.dealcard());
            play=deck.getLastcard();
        }
        return play;
    }

    public void setHand(Card c) {
        hand.add(c);
    }

    public int totalSuit(LinkedList<Card> hand, String suit){//discover how many cards of each suit are present in the hand
        String spade=String.valueOf((char) 9824);
        int st=0;
        String club=String.valueOf((char) 9827);
        int ct=0;
        String heart=String.valueOf((char)9829);
        int ht=0;
        String diamond=String.valueOf((char)9830);
        int dt=0;
        int out=0;
        for (Card a:hand){
            if(a.getSuit().equals(String.valueOf((char) 9824))) {
                st++;//total spades
            }else if(a.getSuit().equals(String.valueOf((char) 9827))) {
                ct++;//total clubs
            }else if (a.getSuit().equals(String.valueOf((char)9829))) {
                ht++;//total hearts
            }else if (a.getSuit().equals(String.valueOf((char)9830))){
                dt++;//total diamonds
            }
        }

        if (suit.equals(spade)) {
            out=st;
        }else if (suit.equals(club)) {
            out=ct;
        }else if (suit.equals(heart)){
            out=ht;
        }else if (suit.equals(diamond)){
            out=dt;
        }
        return out; //returns total cards of suit in hand
    }


    public int getSize(){
        return hand.size();
    }
    public String biggestSuit(LinkedList<Card> hand){
        HashMap<String,Integer>suits=new HashMap<>();
        String spade=String.valueOf((char) 9824);
        int st=0;
        String club=String.valueOf((char) 9827);
        int ct=0;
        String heart=String.valueOf((char)9829);
        int ht=0;
        String diamond=String.valueOf((char)9830);
        int dt=0;

        for (Card a:hand){
            if(a.getSuit().equals(String.valueOf((char) 9824))) {
                st++;
            }else if(a.getSuit().equals(String.valueOf((char) 9827))) {
                ct++;
            }else if (a.getSuit().equals(String.valueOf((char)9829))) {
                ht++;
            }else if (a.getSuit().equals(String.valueOf((char)9830))){
                dt++;
            }
        }
        suits.put(spade,st);
        suits.put(club,ct);
        suits.put(heart,ht);
        suits.put(diamond,dt);

        String out = null;
        int big=0;
        for (String s:suits.keySet()) {
            if(suits.get(s)>big){
                big=suits.get(s);
                out=s;
            }
        }
        return out;
    }

}
