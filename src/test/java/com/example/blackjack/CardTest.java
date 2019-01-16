/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blackjack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author steve
 */
public class CardTest {

    public CardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void simpleCardTest() {
        Card testCard = new Card(Suit.HEARTS, Rank.JACK);
        //a jack should be equal to 10
        assertEquals(10, (int) testCard.value);
    }

    @Test
    public void simpleDeckTest() {
        Deck testDeck = new Deck();
        //top card on the deck should be the Ace of Diamonds
        Card topCard = testDeck.deal();
        assertEquals(Rank.ACE, topCard.rank);
        assertEquals(Suit.DIAMONDS, topCard.suit);
        assertEquals(11, (int) topCard.value);
    }

}
