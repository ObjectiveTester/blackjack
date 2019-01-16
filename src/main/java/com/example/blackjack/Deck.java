/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blackjack;

import java.util.ArrayList;
import java.util.Collections;

class Deck {

    private ArrayList<Card> deck;
    private int currentCard = -1;

    protected Deck() {
        build(1);
    }

    protected Deck(int packs) {
        build(packs);
    }

    private void build(int count) {
        deck = new ArrayList<>();
        //how many packs of cards in the deck
        for (int pack = 0; pack < count; pack++) {
            for (Suit s : Suit.values()) {
                for (Rank r : Rank.values()) {
                    deck.add(new Card(s, r));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
        currentCard = -1;
    }

    public Card deal() {
        currentCard++;
        return (Card) deck.get(currentCard);
    }

}
