package com.Heather;

import java.util.*;

/**
 * Created by cryst on 3/22/2016.
 */
public class Hand {
    protected LinkedList<Card> hand;
    protected HashMap<String,Integer> totalsuit;
    protected String name;

    Hand(String name){
        this.name=name;
        this.hand=new LinkedList<>();
        this.totalsuit=new HashMap<>();
    }



}
