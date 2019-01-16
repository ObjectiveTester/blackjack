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
public class PlayerTest {

    public PlayerTest() {
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
    public void simplePlayerAcesTest() {
        Player testPlayer = new Player("test", 0.0);
        testPlayer.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        testPlayer.addCard(new Card(Suit.CLUBS, Rank.ACE));
        //two aces = 12
        assertEquals(12, (int) testPlayer.getValue());
        testPlayer.addCard(new Card(Suit.HEARTS, Rank.ACE));
        testPlayer.addCard(new Card(Suit.SPADES, Rank.ACE));
        //four aces = 14
        assertEquals(14, (int) testPlayer.getValue());
        testPlayer.addCard(new Card(Suit.DIAMONDS, Rank.KING));
        //four aces + one king = 14
        assertEquals(14, (int) testPlayer.getValue());
    }

    @Test
    public void gotBlackjackTest() {
        Player testPlayer = new Player("test", 0.0);
        testPlayer.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        testPlayer.addCard(new Card(Suit.CLUBS, Rank.KING));
        //natural blackjack
        assertTrue(testPlayer.hasBlackjack());
        //blackjack = 21
        assertEquals(21, (int) testPlayer.getValue());
    }
}
