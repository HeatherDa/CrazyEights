package com.Heather;
import java.util.*;

/**
 * Created by cryst on 3/13/2016.
 */
public class Card {
    //
    private String name;
    private String suit;
    private String value;

    Card(String cardsuit, String cardvalue){
        this.name=String.valueOf(cardvalue)+" of "+cardsuit;
        this.suit=cardsuit;
        this.value=cardvalue;
    }

    public String getName() {
        return name;
    }
    public void setSuit(String suit){
        this.suit=suit;
    }
    public String getSuit(){
        return suit;
    }
    public String getValue(){
        return value;
    }

    public void setColor(){
        String ANSI_black="\u001B[30m";
        String ANSI_red="\u001B[31m";
        String ANSI_reset_color="\u001B[0m";
        if (this.suit.equals(String.valueOf(9824))||this.suit.equals(String.valueOf(9827))){ //not working
            this.name=ANSI_black+this.name+ANSI_reset_color;
        }else{
            this.name=ANSI_red+this.name+ANSI_reset_color;
        }
    }
}
