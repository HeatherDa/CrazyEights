package com.Heather;

import java.util.*;

public class Player {
    //Player's hand and error testing
    Scanner scan=new Scanner(System.in);
    private LinkedList<Card> hand;
    private String name;

    Player(String name){
        this.name=name;
        this.hand=new LinkedList<>();

    }
    public Card getPlay(Deck deck) {
        Card play = null;
        LinkedList<Card> plays = playable(deck);
        Card last = deck.getLastcard();
        String name = last.getName();
        System.out.println("The top card is " + name + ".");
        System.out.println("You have the following cards: ");
        int numdraw = 0;
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + "\t" + (hand.get(i)).getName());
            numdraw = i;
        }
        System.out.println((numdraw + 1) + "\tDraw a Card.");

        int next=testInt();
        if (next == hand.size()) {
            this.hand.add(deck.dealcard());
            play = deck.getLastcard();
        } else {
            Card choice = this.hand.get(next);

            do {
                if (plays.contains(choice) && (choice.getValue().equals("8"))) {
                    play=anEight(choice, deck);
                } else if (plays.contains(choice)) {
                    play = choice;
                    this.hand.remove(choice);
                } else {
                    System.out.println("That is not a valid play.  Try again.");
                    next=testInt();
                    if (next==hand.size()) {
                        this.hand.add(deck.dealcard());
                        play = deck.getLastcard();
                    } else {
                        choice = this.hand.get(next);
                    }
                }
            } while (play == null);
        }
        return play;
    }

    public void setHand(Card c) {
        hand.add(c);
    }

    public int getSize(){
        return hand.size();
    }

    public LinkedList<Card> playable(Deck deck){
        LinkedList<Card>playcards=new LinkedList<>();
        Card last=deck.getLastcard();
        for (Card card:this.hand) {
            if ((card.getValue().equals(last.getValue())) && (!last.getValue().equals("8"))) { //sometimes get error message citing this line and line 18 of Player, and line 17 in CrazyEights.  Can't figure out why.
                playcards.add(card);
            }else if ((card.getSuit().equals(last.getSuit())) && (!card.getValue().equals("8"))) {
                playcards.add(card);
            }else if (card.getValue().equals("8")) {
                playcards.add(card);
            }
        }
        //for(Card c:playcards) { //for troubleshooting playable function
        //    System.out.println(c.getName());
        //}
        return playcards;
    }
    public Integer testInt(){
        boolean isint;
        int next=0;
        do {//test for correct input
            System.out.println("\nTo make a play, type the number in front of the card and hit enter.");


            if (scan.hasNextInt()) {
                next = scan.nextInt();
                isint = true;
            } else {
                System.out.println("Not a valid choice.  Please type an integer.");
                isint = false;
                scan.next();
            }
        } while (!(isint));
        return next;
    }
    public Card anEight(Card play, Deck deck){
        int count = 0;
        String ANSI_black = "\u001B[30m";
        String ANSI_red = "\u001B[31m";
        String ANSI_reset_color = "\u001B[0m";

        for (String s : deck.getSuits()) {//display list of suits to choose from
            if ((s.equals(String.valueOf((char) 9824))) || s.equals(String.valueOf((char) 9827))) {
                System.out.println(count + "\t" + ANSI_black + s + ANSI_reset_color);
                count++;
            } else {
                System.out.println(count + "\t" + ANSI_red + s + ANSI_reset_color);
                count++;
            }
        }
        System.out.println("What suit do you want to change to? Select number and type enter.");

        int newsuitnum = testInt();
        String newsuit = (deck.getSuits()).get(newsuitnum);
        deck.setLastcard(play);
        deck.setNewsuit(newsuit);//change suit of last card
        this.hand.remove(play);
        Card last = deck.getLastcard();
        String news;//holder for new suit
        if ((last.getSuit().equals(String.valueOf((char) 9824))) || last.getSuit().equals(String.valueOf((char) 9827))) {
            news=ANSI_black + last.getSuit() + ANSI_reset_color;
        } else {
            news=ANSI_red + last.getSuit() + ANSI_reset_color;
        }

        System.out.println("The new suit is "+news);
        return play;
    }
}

