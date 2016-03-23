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
        String ANSI_black="\u001B[30m";
        String ANSI_red="\u001B[31m";
        String ANSI_blue="\u001B[34m";
        String ANSI_reset_color="\u001B[0m";
        String spade=String.valueOf((char) 9824);
        String club=String.valueOf((char) 9827);
        String heart=String.valueOf((char)9829);
        String diamond=String.valueOf((char)9830);
        if (this.suit.equals(spade)||this.suit.equals(club)){ //not working
            this.name=ANSI_blue+this.value+ANSI_reset_color+" of "+ANSI_black+this.suit+ANSI_reset_color;
        }else{
            this.name=ANSI_blue+this.value+ANSI_reset_color+" of "+ANSI_red+this.suit+ANSI_reset_color;
        }
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
        String spade=String.valueOf((char) 9824);
        String club=String.valueOf((char) 9827);
        if (this.suit.equals(spade)||this.suit.equals(club)){ //not working
            this.name=ANSI_black+this.name+ANSI_reset_color;
        }else{
            this.name=ANSI_red+this.name+ANSI_reset_color;
        }
    }
}
