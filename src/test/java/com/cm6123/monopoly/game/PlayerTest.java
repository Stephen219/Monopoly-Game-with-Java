package com.cm6123.monopoly.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    // this is the object that will be used to get the player methods.
    Player player =new Player("John",1);

    @Test
    void testThegetNameOfThePlayer() {
        assertEquals("John", player.getName());
    }
    @Test
    void testThePieceOfThePlayer() {
        assertEquals(1,player.getPiece());
    }
    @Test
    void testTheMoneyOfThePlayer(){
        assertEquals(1000, player.getMoney());
    }
    @Test
    public void testSetMoneyInBothSubtractionAndAddition() {
        // given 500 is added to the player
        player.setMoney(500);
        // then the emoney should be equal to 1500
        assertEquals(1500, player.getMoney());
        // given i subtract 200
        player.setMoney(-200);
        // then money should be 1300
        assertEquals(1300, player.getMoney());
    }
    @Test
    void testGetDoublesAddDoublesResetDoubles() {
        // given the player has no doubles
        assertEquals(0, player.getDoubles());
        // given i add 2 doubles
        player.addDoubles();
        player.addDoubles();
        //i should get 2 doubles
        assertEquals(2, player.getDoubles());
        // given i reset doubles
        player.resetDoubles();
        assertEquals(0, player.getDoubles());
    }
}