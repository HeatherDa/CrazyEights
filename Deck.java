package com.Heather;
import java.util.*;

/**
 * Created by cryst on 3/14/2016.
 */
public class Deck {

    private LinkedList<Card>theDeck=new LinkedList<>();
    private Card lastcard;
    private ArrayList<String> values=new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"));
    private ArrayList<String>suits=new ArrayList<>(Arrays.asList(String.valueOf((char) 9824), String.valueOf((char) 9827), String.valueOf((char)9829), String.valueOf((char)9830)));

    Deck(){
        for (String suit:suits){
            for (String value:values){
                Card c=new Card(suit, value);
                c.setColor();
                theDeck.add(c);
            }
        }
    }

    public void setLastcard(Card lastcard) {
        this.lastcard = lastcard;
    }

    public Card getLastcard() {
        return this.lastcard;
    }

    public ArrayList<String> getSuits() {
        return suits;
    }
    public void setNewsuit(String suit){
        lastcard.setSuit(suit);

    }

    public ArrayList<String> getValues() {
        return values;
    }

    //method to deal a card.  Chooses random card from deck by index and removes it.
    public Card dealcard(){
        //random number generated in range theDeck.size
        Random num = new Random();
        int r = num.nextInt(theDeck.size());
        Card card=theDeck.remove(r);
        return card;
    }
    //reshuffle method?  Generate new deck and remove cards in play from it.  Use if game runs out of cards (unlikely scenario.)
}
