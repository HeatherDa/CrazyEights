package com.Heather;

import java.util.*;

/**
 * Created by cryst on 3/14/2016.
 */
public class Computer{
    private LinkedList<Card> hand;

    //Computer's hand and decision mechanics
    Computer(){
        this.hand=new LinkedList<>();
    }

    public Card getPlay(Deck deck){
        Card last=deck.getLastcard();
        Card play=null;
        int matchval=0;
        int matchsuit=0;
        int eight=0;
        ArrayList<Card>mval=new ArrayList<>();
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
        if((matchval!=0)&&(matchsuit!=0)) {
            //compare totalSuit for matching numbercard and totalSuit for last.getSuit()
            for (Card c : mval) {
                if (totalSuit(hand, c.getSuit()) > matchsuit) {
                    play = c;
                    this.hand.remove(c);//remove the card from the hand after playing it
                } else if (totalSuit(hand, c.getSuit()) < matchsuit) {
                    play = msuit.get(0);
                    this.hand.remove(c);//remove the card from the hand after playing it
                }
            }
        }else if((matchval==0)&&(matchsuit>0)){
            play = msuit.get(0);
            this.hand.remove(play);
        }else if((matchval>0)&&(matchsuit==0)){
            play = mval.get(0);
            this.hand.remove(play);
        }else if ((matchval==0)&&(matchsuit==0)&&(eight>0)){//if the only move available is an eight
            deck.setNewsuit(biggestSuit(this.hand));//change suit of last card
            play = deck.getLastcard();//return new "last card"
            this.hand.remove(play);
        }else if ((matchval==0)&&(matchsuit==0)&&(eight==0)){//if no moves available
            deck.dealcard();
        }
        return play;
    }

    public void setHand(Card c) {
        hand.add(c);
    }

    public int totalSuit(LinkedList<Card> hand, String suit){//discover how many cards of each suit are present in the hand
        ArrayList<Integer> totalsuit=new ArrayList<>();
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

    public HashMap<String, Card> values() {
        HashMap<String, Card>handvalues=new HashMap<>();
        for (Card b:hand){
            if (!handvalues.keySet().contains(b.getValue())){
                handvalues.put(b.getValue(),b);
            }
        }
        return handvalues;
    }

    public int getSize(){
        return hand.size();
    }
    public String biggestSuit(LinkedList<Card> hand){
        ArrayList<Integer> totalsuit=new ArrayList<>();
        HashMap<String,Integer>suits=new HashMap<>();
        String spade=String.valueOf((char) 9824);
        int st=0;
        suits.put(spade,st);
        String club=String.valueOf((char) 9827);
        int ct=0;
        suits.put(club,ct);
        String heart=String.valueOf((char)9829);
        int ht=0;
        suits.put(heart,ht);
        String diamond=String.valueOf((char)9830);
        int dt=0;
        suits.put(diamond,dt);
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
