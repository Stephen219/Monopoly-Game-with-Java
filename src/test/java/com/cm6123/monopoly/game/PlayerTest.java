package com.cm6123.monopoly.game;

import com.cm6123.monopoly.dice.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    // this is the object that will be used to test the player methods.
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
        //then I should get 0 doubles.
        assertEquals(0, player.getDoubles());
    }
    @Test
    // testing the move space even after passing go
    // it also tests whether the player gets the money after passing go.
    void testMoveSpaceEvenafterPassingGo(){
        // given the player is on space 0 that is home
        assertEquals(0, player.getSpace());
        // the playe r should have 1000 -- mmh at first.. TODO ..
        assertEquals(1000, player.getMoney());
        // given the player rolls 7.
        player.movePiece(7);
        // then the player should be on space 7
        assertEquals(7, player.getSpace());
        // checking the money
        assertEquals(1000, player.getMoney());
        // given that the same player rolls a ten
        player.movePiece(10);
        // then the player should be on space 1    that is 7 + 10 -16 meaning they passed go.
        assertEquals(1, player.getSpace());
        // checking whether the player got the money since tyhy passed go.
        assertEquals(1200, player.getMoney());
    }
    @Test
    void testPropertiesOperation(){
        // given the player has no properties
        assertEquals(0, player.getProperties());
        // given the player buys a property
        player.addProperty();
        // then the player should have 1 property
        assertEquals(1, player.getProperties());
        // given the player buys another property
        player.addProperty();
        // then the player should have 2 properties
        assertEquals(2, player.getProperties());
        // given the player sells a property
        player.sellProperty();
        // then the player should have 1 property
        assertEquals(1, player.getProperties());
        // given the player sells another property
        player.sellProperty();
        // then the player should have 0 properties
        assertEquals(0, player.getProperties());
    }

}