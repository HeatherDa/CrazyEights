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
            System.out.println(i+"\t"+(hand.get(i)).getName());
        }
        System.out.println("To make a play, type the number in front of the card and hit enter.  Hit enter without typing to draw a card.");
        String next=scan.nextLine();
        if (next.equals("")){
            this.hand.add(deck.dealcard());
            play=deck.getLastcard();
        }else{
            Card choice=this.hand.get(Integer.parseInt(next));

            do{         //MUST ADD OPTION FOR CHANGING SUIT
                if (plays.contains(choice)&&(choice.getValue().equals("8"))){
                    play=choice;
                    System.out.println("What suit do you want to change to? Select number and hit enter.");
                    int count=0;
                    String ANSI_black="\u001B[30m";
                    String ANSI_red="\u001B[31m";
                    String ANSI_reset_color="\u001B[0m";
                    for(String s:deck.getSuits()){
                        if((s.equals(String.valueOf((char) 9824)))||s.equals(String.valueOf((char) 9827))){
                            System.out.println(ANSI_black+s+ANSI_reset_color);
                            count++;
                        }else {
                            System.out.println(ANSI_red + s + ANSI_reset_color);
                            count++;
                        }
                    }

                    int newsuitnum=scan.nextInt();
                    String newsuit=(deck.getSuits()).get(newsuitnum);
                    deck.setLastcard(play);
                    deck.setNewsuit(newsuit);//change suit of last card
                    this.hand.remove(play);
                    last=deck.getLastcard();
                    System.out.println("The new suit is "+last.getSuit());
                }else if (plays.contains(choice)) {
                    play = choice;
                    this.hand.remove(choice);
                } else {
                    System.out.println("That is not a valid play.  Try again.");
                    next=scan.nextLine();
                    if (next.equals("")){
                        this.hand.add(deck.dealcard());
                        play=deck.getLastcard();
                    }else {
                        choice = this.hand.get(Integer.parseInt(next));
                    }
                }
            }while(play==null);
        }
        return play;
    }

    public void setHand(Card c) {
        hand.add(c);
    }

    public int getSize(){
        return hand.size();
    }

    public LinkedList<Card> playable(Deck deck){//doesn't seem to be adding any cards to list
        LinkedList<Card>playcards=new LinkedList<>();
        Card last=deck.getLastcard();
        for (Card card:this.hand) {
            if ((card.getValue().equals(last.getValue())) && (!last.getValue().equals("8"))) {
                playcards.add(card);
            }else if ((card.getSuit().equals(last.getSuit())) && (!card.getValue().equals("8"))) {
                playcards.add(card);
            }else if (card.getValue().equals("8")) {
                playcards.add(card);
            }
        }
        return playcards;
    }
}
