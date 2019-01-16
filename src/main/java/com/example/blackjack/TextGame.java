/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blackjack;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

 public class TextGame {

    public static void main(String args[]) {

        Deck deck = new Deck(6);
        deck.shuffle();

        Scanner scan = new Scanner(System.in);
        NumberFormat df = new DecimalFormat("#.00");  

        System.out.println("Blackjack game\n");
        //System.out.println("\nWhat's your name?");
        //String s = scan.nextLine();
        String s = "player";
        System.out.println("hello " + s);

        Player one = new Player(s, 10.0);
        Player d = new Player("dealer", 0.0);
        double bet = 1.0;
        //game loop
        boolean playing = true;
        while (playing) {

            System.out.println(one.playerName + " has " + df.format(one.balance));
            
            System.out.println("bet ("+df.format(bet)+"), or 0 to quit");
            String in = scan.nextLine();
            if (in.isBlank()) {
                //use default
            } else {
                try {
                    bet = Double.valueOf(in);

                } catch (java.lang.NumberFormatException ex) {
                    bet = 0.0;
                }
            }

            if (bet > 0) {
                System.out.println(one.playerName + " has bet " + df.format(bet));
                if (one.balance < bet) {
                    System.out.println(one.playerName + " only has " + df.format(one.balance) + "left");
                    bet = one.balance;
                }

                one.balance = one.balance - bet;

                //deal the cards
                one.addCard(deck.deal());
                d.addCard(deck.deal());
                one.addCard(deck.deal());
                d.addCard(deck.deal());

                System.out.println(d.playerName + " shows " + d.getFirstCard());

                boolean playerFinished = false;
                Boolean dealerFinished = false;

                if (one.hasBlackjack()) {
                    playerFinished = true;
                    System.out.println(one.playerName + " has Blackjack!");
                } else {
                    System.out.println(one.playerName + " has " + one.getHand() + "(" + one.getValue() + ")");
                }

                //player loop
                while (!playerFinished) {
                    String choice;

                    do {
                        System.out.println("stick(s) or twist(t) ?");
                        choice = scan.nextLine().toLowerCase();
                    } while ((!choice.equals("s")) && (!choice.equalsIgnoreCase("t")));

                    switch (choice) {
                        case "t":
                            Card c = deck.deal();
                            System.out.println(one.playerName + " is dealt " + c.ident());
                            one.addCard(c);
                            if (one.getValue() > 21) {
                                playerFinished = true;
                            }
                            System.out.println(one.playerName + " has " + one.getValue());
                            break;

                        case "s":
                            playerFinished = true;
                            break;
                    }
                }
                if (one.getValue() > 21) {
                    System.out.println(one.playerName + " is bust!");
                    dealerFinished = true;
                }

                //dealer loop
                if (d.hasBlackjack()) {
                    dealerFinished = true;
                    System.out.println(d.playerName + " has Blackjack!");
                } else {
                    System.out.println(d.playerName + " has " + d.getHand() + "(" + d.getValue() + ")");
                }

                while (!dealerFinished) {

                    if (d.getValue() <= 16) {

                        Card c = deck.deal();
                        System.out.println(d.playerName + " is dealt " + c.ident());
                        d.addCard(c);
                        System.out.println(d.playerName + " has " + d.getValue());
                        if (d.getValue() > 21) {
                            dealerFinished = true;
                            System.out.println(d.playerName + " is bust!");
                        }

                    } else {
                        dealerFinished = true;
                    }
                }
                //payout
                if (one.getValue() > 21) {
                    System.out.println("player looses");
                    if (one.balance == 0.0) {
                        playing = false;
                    }
                } else if (one.hasBlackjack() && !d.hasBlackjack()) {
                    System.out.println("player wins " + (df.format(bet * 2.5)));
                    one.balance = one.balance + (bet * 2.5);
                } else if (((one.getValue() > d.getValue())) || (d.getValue() > 21)) {
                    System.out.println("player wins " + (df.format(bet * 2)));
                    one.balance = one.balance + (bet * 2);
                } else if (d.getValue() >= one.getValue()) {
                    System.out.println("dealer wins ");
                }
            } else {
                System.out.println(one.playerName + " leaves the game with " + df.format(one.balance));
                playing = false;
            }
            one.reset();
            d.reset();
            if (one.balance <= 0) {
                System.out.println(one.playerName + " is broke!");
                playing = false;
            }
        }
        System.out.println("byee");
    }
}
