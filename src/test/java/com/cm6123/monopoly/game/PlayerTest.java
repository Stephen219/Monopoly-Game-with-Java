package com.cm6123.monopoly.game;

import com.cm6123.monopoly.dice.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    // this is the object that will be used to test the player methods.
    Player player =new Player("John",1);

    @Test
    // testing the getName method
    void testThegetNameOfThePlayer() {
        assertEquals("John", player.getName());
    }
    @Test
    // testing the getPiece method
    void testThePieceOfThePlayer() {
        assertEquals(1,player.getPiece());
    }
    @Test
    // testing the getMoney method
    void testTheMoneyOfThePlayer(){
        assertEquals(1000, player.getMoney());
    }
    @Test
    // testing the setMoney method in both add and subtract
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
    // testing the addDoubles,get doubles and reset doubles  methods
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
        // the player should have 1000 -- mmh at first.. TODO ..
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
    //testing the property operations
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
    Property property = new Property("Park Place", 0, 0, "Blue", 350, 35, 3);
    Property property2 = new Property("may fair", 0, 0, "Blue", 350, 35, 5);

    // testing the add property method
    @Test
    void testAddProperty() {
        //initialising the player
        Player player = new Player("Valary", 1);
        //gven i add a property to the player
        player.addProperty(property);
        // then the player should have 1 property
        assertEquals(1, player.getPropertiesArray().size(), "Adding a property to the player should increase the size of the properties array by 1");
    }
    @Test
    void testGetPropertiesArray() {
        //initialising the player
        Player player = new Player("valary", 1);
        assertEquals(0, player.getPropertiesArray().size());
        // given i add 2 properties to the player
        player.addProperty(property);
        player.addProperty(property2);
        // then the player should have 2 properties
        assertEquals(2, player.getPropertiesArray().size());
        // then the array should have property and property2
        assertTrue(player.getPropertiesArray().contains(property));
        assertTrue(player.getPropertiesArray().contains(property2));
    }

}