package com.cm6123.monopoly.game;

import java.util.ArrayList;
import java.util.List;

public final class  Board extends Property {
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
    private Board(final String propertyname, final String proprtyOwner, final int propertyType, final String propertyColourGroup, final int propertyCost, final int propertyRent, final int propertySpace) {
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
                new Property("road", null, 2, "Grey", 0, 0, 1),
                new Property("king's Cross Station", null, 1, "Grey", 0, 0, 2),
                new Property("old Kent", null, 0, "Orange", 900, 80, 3),
                new Property("pall Mall", null, 0, "Orange", 900, 90, 4),
                new Property("road2", null, 2, "Grey", 0, 0, 5),
                new Property("paddington", null, 0, "Grey", 850, 80, 6),
                new Property("mayfair", null, 0, "Grey", 780, 95, 7),
                new Property("the Strand", null, 0, "Grey", 980, 85, 8),
                new Property("road4", null, 2, "Grey", 0, 0, 9),
                new Property("tax Office", null, 3, "Grey", 0, 0, 10),
                new Property("water Works", null, 0, "Grey", 400, 40, 11),
                new Property("leicester Square", null, 0, "Grey", 780, 78, 12),
                new Property("liverpool Station", null, 1, "Grey", 0, 0, 13),
                new Property("park Lane", null, 0, "Grey", 750, 68, 14),
                new Property("road6", null, 2, "Grey", 0, 0, 95),
                new Property("bond Street", null, 0, "Grey", 800, 80, 16),
                new Property("liverpool Street", null, 0, "Grey", 700, 69, 17),
                new Property("regent Street", null, 0, "Yellow", 750, 75, 18),
                new Property("electric Company", null, 0, "Yellow", 400, 98, 19),
                new Property("Oxford Street", null, 0, "Yellow", 1000, 92, 20),
                new Property("Piccadilly", null, 0, "Yellow", 900, 85, 21),
                new Property(" Marylebone Station", null, 1, "Yellow", 0, 0, 22)
        ));
    }
}
