package com.Heather;
import java.util.*;

/**
 * Created by cryst on 3/14/2016.
 */
public class Deck {

    private LinkedList<Card>theDeck;

    Deck(){
        ArrayList<String> values=new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"));
        ArrayList<Character>suits=new ArrayList<>(Arrays.asList((char) 9824, (char) 9827, (char)9829, (char)9830));
        for (Character suit:suits){
            String name=String.valueOf(suit);
            for (String value:values){
                Card c=new Card(name, value);
                c.setColor();
                theDeck.add(c);
            }
        }
    }

    //method to deal a card.  Chooses random card from deck by index and removes it.
    public Card dealcard(){
        //random number generated in range theDeck.size
        Random num = new Random();
        int r = num.nextInt(theDeck.size()+1);//why+1?
        Card card=theDeck.remove(r);
        return card;
    }
    //reshuffle method?  Generate new deck and remove cards in play from it.  Use if game runs out of cards (unlikely scenario.)
}
