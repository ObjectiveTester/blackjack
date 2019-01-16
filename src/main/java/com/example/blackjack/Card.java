/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blackjack;

class Card {

    Suit suit;
    Rank rank;
    Integer value;

    protected Card(Suit s, Rank r) {
        this.suit = s;
        this.rank = r;
        switch (rank) {
            case ACE:
                value = 11;
                break;
            case KING:
                value = 10;
                break;
            case QUEEN:
                value = 10;
                break;
            case JACK:
                value = 10;
                break;
            case TEN:
                value = 10;
                break;
            case NINE:
                value = 9;
                break;
            case EIGHT:
                value = 8;
                break;
            case SEVEN:
                value = 7;
                break;
            case SIX:
                value = 6;
                break;
            case FIVE:
                value = 5;
                break;
            case FOUR:
                value = 4;
                break;
            case THREE:
                value = 3;
                break;
            case TWO:
                value = 2;
                break;
        }

    }

    public String ident() {
        return (rank + " of " + suit);
    }

}
