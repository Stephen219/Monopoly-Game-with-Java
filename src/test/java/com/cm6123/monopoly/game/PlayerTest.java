package com.cm6123.monopoly.game;

import com.cm6123.monopoly.dice.Dice;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    // this is the object that will be used to test the player methods.
    // it is instantiated here so that it can be used in all the tests
    Player player =new Player("John");

    @Test
    // testing the getName method
    void testThegetNameOfThePlayer() {
        assertEquals("John", player.getName());
    }

    @Test
    // testing the getMoney method
    void testTheMoneyOfThePlayer(){
        assertEquals(1000, player.getMoney());
    }
    @Test
    // testing the setMoney method in both add and subtract
    public void testSetMoneyInBothSubtractionAndAddition() {
        // given a player who initially has 1000
        Player player = new Player("John");
        // when i add 500
        player.setMoney(500);
        // then the emoney should be equal to 1500
        assertEquals(1500, player.getMoney());
        // when i subtract 200
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
        Player player2 = new Player("John");
        // given the player is on space 0 that is home and has 1000
        assertEquals(0, player2.getSpace());
        assertEquals(1000, player2.getMoney());
        // when the player rolls a 12 (hence should move ahead 12 spaces)
        player2.movePiece(12);
        // then the player should be on space 12
        assertEquals(12, player2.getSpace());
        // and the player should have 1000
        assertEquals(1000, player.getMoney());
        // given that the same player rolls a twelve
        player2.movePiece(12);
        // then the player should be on space 1 that is 12+12 meaning they passed go since the board has 23 spaces
        assertEquals(1, player2.getSpace());
        // and the player should have 1200 that is 1000 + 200 for passing go.
        assertEquals(1200, player2.getMoney());
    }
    Property property = new Property("Park Place", null, 0, "Blue", 350, 35, 3);
    Property property2 = new Property("may fair", null, 0, "Blue", 350, 35, 5);

    // testing the add property method
    @Test
    void testAddProperty() {
        //initialising the player
        Player player = new Player("Valary");
        //gven i add a property to the player
        player.addProperty(property);
        // then the player should have 1 property
        assertEquals(1, player.getPropertiesArray().size(), "Adding a property to the player should increase the size of the properties array by 1");
    }
    @Test
    void testGetPropertiesArray() {
        //initialising the player
        Player player = new Player("valary");
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
    //testing the default constructor with no parameters
    @Test
    public void testDefaultConstructor() {
        // given a player with no name and piece initialised
        Player player = new Player();
        // then the player should have the following attributes
        assertEquals("UNKNOWN", player.getName());
        assertEquals("Unknown", player.getPieceName());
        assertEquals(0, player.getSpace());
        assertEquals(1000, player.getMoney());
        assertEquals(0, player.getDoubles());
        assertEquals(0, player.getProperties());
        assertTrue(player.getPropertiesArray().isEmpty());
    }
    // testing the parameterized constructor with the name and piece

    @Test
    public void testParameterizedConstructorWithTheNameAndPiece() {
        // given a player with the name and piece initialised to John and 1 respectively
        Player player = new Player("John");
        // then the player should have the following attributes
        assertEquals("John", player.getName());
        assertEquals("Unknown", player.getPieceName());
        assertEquals(0, player.getSpace());
        assertEquals(1000, player.getMoney());
        assertEquals(0, player.getDoubles());
        assertEquals(0, player.getProperties());
        assertTrue(player.getPropertiesArray().isEmpty());
    }


    @Test
    public void testBuyProperty() {
        //given a player with 1000 money and two properties initialised to property4 and property5
        Player player = new Player("John");
        Property property4= new Property("Park Place", null, 0, "Blue", 350, 35, 3);
        Property property5 = new Property("may fair", null, 0, "Blue", 750, 35, 5);
        assertEquals(1000, player.getMoney());
        //when the player buys property4 of 350 money which is less than the money they have
        boolean bought = player.buyProperty(property4);
        //then the player should be able to buy the property.
        assertTrue(bought);
        //and the player should have 650 money left after deducting the price of the property
        assertEquals(650, player.getMoney());
        //and the player should have 1 property
        assertEquals(1, player.getProperties());
        //and the player properties array should contain property4
        assertTrue(player.getPropertiesArray().contains(property4));
        //given the same player with 650 money
        assertEquals(650, player.getMoney());
        //when the player wants to buy property5 which is more expensive than the money they have
        boolean bought2 = player.buyProperty(property5);
        //then the player should not be able to buy the property
        assertFalse(bought2);
        //and the player should have 650 money left
        assertEquals(650, player.getMoney());
        //and the player should have 1 property since they did not buy the property5
        assertEquals(1, player.getProperties());
        //and the player properties array should not contain property5
        assertFalse(player.getPropertiesArray().contains(property5));
    }
}