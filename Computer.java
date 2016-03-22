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



    public Card nextcard(Card last){
        HashMap<String, Card> v=values();//unique values
        Card play = null;
        if(((totalSuit(hand, last.getSuit())!=0)||v.keySet().contains(last.getValue()))&&(!last.getValue().equals("8"))){ //if there is a card that matches the suit of the previous card and there is a card that matches the value of the previous card and that value is not 8
            if (totalSuit(hand,last.getSuit())<totalSuit(hand,(v.get(last.getValue()).getSuit()))){//if #cards of prev suit is less than #cards of suit of card matching prev value
                play=v.get(last.getValue()); //play card that matches number HAVEN'T CHECKED FOR MORE THAN ONE CARD WITH SAME VALUE!
            }else if(totalSuit(hand,last.getSuit())>totalSuit(hand,(v.get(last.getValue()).getSuit()))){
                for (Card match:hand){
                    if(match.getSuit().equals(last.getSuit())){
                        play=match; //DO I NEED TO CHECK IF IT'S AN EIGHT HERE OR EARLIER?  IF EARLIER, WHERE?
                        hand.remove(match);
                        break;
                    }
                }
            }
        }else if ((totalSuit(hand, last.getSuit())!=0)&&(!(v.get("8")).getSuit().equals(last.getSuit()))){//suit matches, not an eight maybe?
            for (Card m:hand){
                if(m.getSuit().equals(last.getSuit())){
                    play=m; //DO I NEED TO CHECK IF IT'S AN EIGHT HERE OR EARLIER?  IF EARLIER, WHERE?
                    hand.remove(m);
                    break;
                }
            }
        }else if ()



        /*for (Card c:hand){
            if(v.contains(last.getValue())){
            //if (((c.getSuit().equals(last.getSuit()))|| (c.getValue().equals(last.getValue())))&&(!c.getValue().equals("8"))){//if the card has the same suit or value as the last card played and is not an eight
                if(totalSuit(hand,c.getSuit())>totalSuit(hand, last.getSuit())){
                    //play card of
                }
            }else if()
        }*/

        return play;
    }







    public void setHand(Card c) {
        hand.add(c);
    }

    public ArrayList<Integer> totalSuit(LinkedList<Card> hand){//discover how many cards of each suit are present in the hand
        ArrayList<Integer> totalsuit=new ArrayList<>();
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
        totalsuit.add(st);
        totalsuit.add(ct);
        totalsuit.add(ht);
        totalsuit.add(dt);
        Collections.sort(totalsuit);//sort list from smallest to largest
        ArrayList<Integer>tsbiggest=new ArrayList<>();
        tsbiggest.add(totalsuit.get(3));
        tsbiggest.add(totalsuit.get(2));
        tsbiggest.add(totalsuit.get(1));
        tsbiggest.add(totalsuit.get(0));

        return tsbiggest; //returns total cards for each suit in order from largest to smallest
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
}
