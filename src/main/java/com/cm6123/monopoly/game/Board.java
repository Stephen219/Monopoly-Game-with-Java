package com.cm6123.monopoly.game;

import java.util.ArrayList;
import java.util.List;

public class Board extends Property {
    /**
     * An ArrayList of Property objects to which the properties will be added to.
     */
    private ArrayList<Property> properties;

    /**
     * Constructor for creating a Board object with the given property details using inheritance from.
     * the Property class. The constructor takes the following parameters:
     *
     * @param propertyname        is the name of the Property
     * @param proprtyOwner        is the owner of the Property
     * @param propertyType        is the value of a parameter that is not currently being used
     * @param propertyColourGroup is the colour group of the Property
     * @param propertyCost        is the cost of the Property
     * @param propertyRent        is the rent of the Property
     * @param propertySpace       is the space where the Property is located
     */
    public Board(final String propertyname, final String proprtyOwner, final int propertyType, final String propertyColourGroup, final int propertyCost, final int propertyRent, final int propertySpace) {
        super(propertyname, proprtyOwner, propertyType, propertyColourGroup, propertyType, propertyRent, propertySpace);
    }

    /**
     * Assigning initial values to all the Property.
     * objects on a Monopoly board and then adds them to an
     * ArrayList defined and accessible in the main
     * method
     *
     * @param properties an ArrayList of Property objects to which the properties will be added to
     */
    public static void createProperties(final ArrayList<Property> properties) {
        properties.addAll(List.of(
                new Property("Home (go)", null, -1, "Green", 0, 0, 0),
                new Property("Road", null, 2, "Grey", 0, 0, 1),
                new Property("King's Cross Station", null, 1, "Grey", 0, 0, 2),
                new Property("Old Kent", null, 0, "Orange", 160, 16, 3),
                new Property("Pall Mall", null, 0, "Orange", 140, 14, 4),
                new Property("Road2", null, 2, "Grey", 0, 0, 5),
                new Property("Paddington", null, 0, "Grey", 350, 35, 6),
                new Property("Mayfair", null, 0, "Grey", 400, 40, 7),
                new Property("The Strand", null, 0, "Grey", 220, 22, 8),
                new Property("Road4", null, 2, "Grey", 0, 0, 9),
                new Property("Tax Office", null, 3, "Grey", 0, 0, 10),
                new Property("Water Works", null, 0, "Grey", 350, 34, 11),
                new Property("Leicester Square", null, 0, "Grey", 260, 26, 12),
                new Property("Liverpool Station", null, 1, "Grey", 0, 0, 13),
                new Property("Park Lane", null, 0, "Grey", 150, 15, 14),
                new Property("Road6", null, 2, "Grey", 0, 0, 15),
                new Property("Bond Street", null, 0, "Grey", 200, 20, 16),
                new Property("Liverpool Street", null, 0, "Grey", 320, 32, 17),
                new Property("Regent Street", null, 0, "Yellow", 280, 28, 18),
                new Property("Electric Company", null, 0, "Yellow", 150, 15, 19),
                new Property("Oxford Street", null, 0, "Yellow", 300, 30, 20),
                new Property("Piccadilly", null, 0, "Yellow", 250, 25, 21),
                new Property(" Marylebone Station", null, 1, "Yellow", 0, 0, 22)
        ));
    }
}
