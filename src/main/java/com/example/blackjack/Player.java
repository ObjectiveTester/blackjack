/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blackjack;

import java.util.ArrayList;

class Player {

    protected String playerName;
    protected ArrayList<Card> hand;
    private int aces;
    private int val = 0;
    protected double balance = 0.0;

    Player(String s, Double b) {
        this.playerName = s;
        this.balance = b;
        hand = new ArrayList<>();
    }

    protected void addCard(Card c) {
        hand.add(c);
        val = val + c.value;
        if (c.rank == Rank.ACE) {
            aces++;
        }
        while ((aces > 0) && (val > 21)) {
            aces--;
            //System.out.println("devalue");
            val = val - 10;
        }
    }

    protected int getValue() {
        return val;
    }

    protected String getFirstCard() {
        return hand.get(0).ident();
    }

    protected String getHand() {
        String h = "";
        for (Card c : hand) {
            h = h + c.ident() + ", ";
        }
        return h;
    }

    protected void reset() {
        val = 0;
        aces = 0;
        hand.clear();
    }

    protected boolean hasBlackjack() {
        if ((val == 21) && (hand.size() == 2)) {
            return true;
        } else {
            return false;
        }
    }
}
