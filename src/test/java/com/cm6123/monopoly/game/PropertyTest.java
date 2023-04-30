package com.cm6123.monopoly.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {
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
        Property property = new Property("Park Place", 0, 0, "Blue", 350, 35, 37);
        property.setOwner(1);
        Assertions.assertEquals(1, property.getOwner());
    }
    @Test
    void testIsOwned(){
        Property property = new Property("Park Place", 0, 0, "Blue", 350, 35, 37);

        assertEquals(false, property.isOwned());
        property.setOwner(1);
        assertEquals(true, property.isOwned());
    }



}