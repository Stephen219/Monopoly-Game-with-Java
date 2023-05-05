package com.cm6123.monopoly.game;

import java.util.ArrayList;
import java.util.List;

public class Board extends Property{
    /** An ArrayList of Property objects to which the properties will be added to.
     */
    private ArrayList<Property> properties;
    /**
     * Constructor for creating a Board object with the given property details using inheritance from.
     * the Property class. The constructor takes the following parameters:
     * @param propertyname is the name of the Property
     * @param proprtyOwner is the owner of the Property
     * @param propertyType is the value of a parameter that is not currently being used
     * @param propertyColourGroup is the colour group of the Property
     * @param propertyCost is the cost of the Property
     * @param propertyRent is the rent of the Property
     * @param propertySpace is the space where the Property is located
     */
    public Board(final String propertyname, final String proprtyOwner, final int propertyType, final String propertyColourGroup, final int propertyCost, final int propertyRent, final int propertySpace) {
        super(propertyname, proprtyOwner, propertyType, propertyColourGroup, propertyType, propertyRent, propertySpace);
    }
    /** Assigning initial values to all the Property.
     *   objects on a Monopoly board and then adds them to an
     *   ArrayList defined and accessible in the main
     *   method
     * @param properties an ArrayList of Property objects to which the properties will be added to
     */
    public static void createProperties(final ArrayList<Property> properties) {
        properties.addAll(List.of(
                new Property("Home", null, -1, "Green", 0, 0, 0),
                new Property("Road", null, 2, "Grey", 0, 20, 1),
                new Property("Station1", null, 1, "Grey", 20, 2960, 2),
                new Property("Old Kent Road", null, 0, "Orange", 980, 1920, 3),
                new Property("Pall Mall", null, 0, "Orange", 950, 1970, 4),
                new Property("Road2", null, 2, "Grey", 0, 0, 5),
                new Property("Paddington", null, 0, "Grey", 970, 870, 6),
                new Property("Mayfair", null, 0, "Grey", 900, 900, 7),
                new Property("The Strand", null, 0, "Grey", 960, 770, 8),
                new Property("Road4", null, 2, "Grey", 0, 2980, 9),
                new Property("Tax Office", null, 3, "Grey", 0, 0, 10),
                new Property("Waterloo", null, 0, "Grey", 900, 800, 11),
                new Property("Leicester Square", null, 0, "Grey", 0, 969, 12),
                new Property("station 2", null, 3, "Grey", 0, 0, 13),
                new Property("Park Lane", null, 0, "Grey", 900, 920, 14),
                new Property("Road6", null, 2, "Grey", 0, 0, 15)
                ));
    }
}
