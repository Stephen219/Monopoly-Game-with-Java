package com.cm6123.monopoly.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {
    // property variable to be used in the tests
    Property property = new Property("Park Place", 0, 0, "Blue", 350, 35, 3);

    @Test
    void testProperty() {
        //getting the name.
        assertEquals("Park Place", property.getName());
        //getting the owner.
        assertEquals(0, property.getOwner());
        //getting the colour group.
        assertEquals("Blue", property.getColourGroup());
        //getting the cost.
        assertEquals(350, property.getCost());
        //getting the rent.
        assertEquals(35, property.getRent());
        //getting the space.
        assertEquals(3, property.gettingSpace());
    }
    @Test
    void testSetOwner() {
        property.setOwner(1);
        Assertions.assertEquals(1, property.getOwner());
    }
    @Test
    void testIsOwned(){
        assertEquals(false, property.isOwned());
        property.setOwner(1);
        assertTrue(property.isOwned());
    }
    @Test
    public void testPropertyDefaultConstructor() {
        //given i create a property with no parameters,
        Property property = new Property();
        //then i expect the following default values to be set.
        assertEquals("UNDEFINED", property.getName());
        assertEquals(0, property.getOwner());
        assertEquals("NONE", property.getColourGroup());
        assertEquals(0, property.getCost());
        assertEquals(0, property.getRent());
        assertEquals(0, property.gettingSpace());
    }
}