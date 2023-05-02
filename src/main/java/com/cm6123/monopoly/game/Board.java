package com.cm6123.monopoly.game;

import java.util.ArrayList;

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
     * @param propertyColour is the cost of the Property
     * @param propertyRent is the rent of the Property
     * @param propertySpace is the space where the Property is located
     */
    public Board(final String propertyname, final int proprtyOwner, final int propertyType, final String propertyColourGroup, final int propertyColour, final int propertyRent, final int propertySpace) {
        super(propertyname, proprtyOwner, propertyType, propertyColourGroup, propertyType, propertyRent, propertySpace);
    }
    /** Assigning initial values to all the Property.
     *   objects on a Monopoly board and then adds them to an
     *   ArrayList defined and accessible in the main
     *   method
     * @param properties an ArrayList of Property objects to which the properties will be added to
     */
    public static void createProperties(final ArrayList<Property> properties) {
        Property home = new Property("Home", 0, -1, "Green", 0, 0, 0);
        Property road = new Property("Road", 0, 2, "Grey", 0, 20, 1);
        Property road2 = new Property("Road1", 0, 2, "Grey", 0, 960, 2);
        Property oldKentRoad = new Property("Old Kent Road", 0, 0, "Orange", 80, 920, 3);
        Property pallMall = new Property("Pall Mall", 0, 0, "Orange", 550, 970, 4);
        Property road3 = new Property("Road2", 0, 2, "Grey", 0, 0, 5);
        Property paddington = new Property("Paddington", 0, 0, "Grey", 170, 870, 6);
        Property mayfair = new Property("Mayfair", 0, 0, "Grey", 900, 900, 7);
        Property theStrand = new Property("The Strand", 0, 0, "Grey", 660, 770, 8);
        Property road5 = new Property("Road4", 0, 2, "Grey", 0, 880, 9);
        Property taxOffice = new Property("Tax Office", 0, 3, "Grey", 0, 0, 10);
        Property waterloo = new Property("Waterloo", 0, 0, "Grey", 900, 80, 11);
        Property leicesterSquare = new Property("Leicester Square", 0, 0, "Grey", 0, 0, 12);
        Property road6 = new Property("Road5", 0, 2, "Grey", 0, 0, 13);
        Property PackLane = new Property("Park Lane", 0, 0, "Grey", 900, 820, 14);
        Property road7 = new Property("Road6", 0, 2, "Grey", 0, 0, 15);
        properties.add(home);
        properties.add(road);
        properties.add(road2);
        properties.add(oldKentRoad);
        properties.add(pallMall);
        properties.add(road3);
        properties.add(paddington);
        properties.add(mayfair);
        properties.add(theStrand);
        properties.add(road5);
        properties.add(taxOffice);
        properties.add(waterloo);
        properties.add(leicesterSquare);
        properties.add(road6);
        properties.add(PackLane);
        properties.add(road7);
    }

}
