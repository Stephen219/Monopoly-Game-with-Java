package com.cm6123.monopoly.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {
    // property variable to be used in the tests
    Property property = new Property("Park Place", null, 0, "Blue", 350, 35, 3);

    @Test
    void testProperty() {
        //getting the name.
        assertEquals("Park Place", property.getName());
        //getting the owner.
        assertNull( property.getOwner());
        //getting the colour group.
        assertEquals("Blue", property.getColourGroup());
        //getting the cost.
        assertEquals(350, property.getPrice());
        //getting the rent.
        assertEquals(35, property.getRent());
        //getting the space.
        assertEquals(3, property.gettingSpace());
    }
    @Test
    void testSetOwner() {
        property.setOwner("john");
        Assertions.assertEquals("john", property.getOwner());
    }
    @Test
    void testgetType(){
        assertEquals(0, property.getType());
    }
    @Test
    void testIsOwned(){
        assertFalse( property.isOwned());
        property.setOwner("john");
        assertTrue(property.isOwned());
    }
    @Test
    public void testPropertyDefaultConstructor() {
        //given i create a property with no parameters,
        Property property = new Property();
        //then i expect the following default values to be set.
        assertEquals("UNDEFINED", property.getName());
        assertEquals(null, property.getOwner());
        assertEquals("NONE", property.getColourGroup());
        assertEquals(0, property.getPrice());
        assertEquals(0, property.getRent());
        assertEquals(0, property.gettingSpace());
    }
}