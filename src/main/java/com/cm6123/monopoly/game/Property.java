package com.cm6123.monopoly.game;
/*A Property is used to keepall the information about all the buyable
properties locations on a monopolyy board. */

public class Property {
    /**
     * Represents the types of properties.
     * buyable properties are represented by 0
     * this is the home  property
     */
    public static final int OTHER = -1;
    /**
     * Represents the types of properties.
     * non-uyable properties are represented by 0
     */
    public static final int PROPERTY = 0;
    /**
     * represents the station properties.
     */
    public static final int STATION = 1;
    /**
     * represents the road properties.
     */
    public static final int ROAD = 2;
    /**
     * represents the tax office properties.
     */
    public static final int TAXOFFICE = 3;
    /**
     * Represents the name of the property.
     */
    private final String name;
    /**
     * Represents the owner of the property.
     */
    private int owner;
    /**
     * Represents the colour group of the property.
     */
    private final String colourGroup;
    /**
     * Represents the cost of the property.
     */
    private final int cost;
    /**
     * Represents the rent of the property.
     */
    private final int rent;
    /**
     * Represents the space of the property.
     */
    private final int space;
    /**
     * Represents the type of the property.
     */
    private  int type;
    /**
     * Creates a standard Property object with blank or zero initial values.
     */
    public Property() {
        name = "UNDEFINED";
        owner = 0;
        colourGroup = "NONE";
        cost = 0;
        rent = 0;
        space = 0;
    }

    /**
     * Creating constructor for the Property class.
     * @param propertyname is the name of the Property
     * @param proprtyOwner is the owner of the Property
     * @param propertyType is the value of a parameter that is not currently being used
     * @param propertyColourGroup is the colour group of the Property
     * @param propertyCost is the cost of the Property
     * @param propertyRent is the rent of the Property
     * @param propertySpace is the space where the Property is located
     */
    public Property(final String propertyname, final int proprtyOwner, final int propertyType, final String propertyColourGroup, final int propertyCost, final int propertyRent, final int propertySpace) {
        name = propertyname;
        owner = proprtyOwner;
        colourGroup = propertyColourGroup;
        cost = propertyCost;
        rent = propertyRent;
        space = propertySpace;
        type= propertyType;
    }

    /**
     * Getting the name of the Property.
     * @return the name of the Property
     */
    public String getName(){
        return name;
    }

    /**
     * Getting the index of the Player who owns the Property.
     * @return the index
     */
    public int getOwner(){
        return owner;
    }

    /**
     * Changing the owner of the Proerty.
     * @param o is the index of the new owner
     */
    public void setOwner(final int o) {
        owner = o;
    }

    /**
     * Getting the colour group of the Property.
     * @return the colour group
     */
    public String getColourGroup() {
        return colourGroup;
    }

    /**
     * Getting the cost of the Property.
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Getting the space where the Property is located of the Property.
     * @return the space
     */
    public int gettingSpace() {
        return space;
    }
    /**
     * Returning all relevant values about a Property.
     * @return the values of a property
     */
    public String toString() {
        return "PROPRERTY: <" + name + ">\n"
                + "(*)Owner = " + owner + "\n"
                + "(*)Colour Group = " + colourGroup + "\n"
                + "(*)Cost = " + cost + "\n"
                + "(*)Rent = " + rent + "\n"
                + "(*)Space = " + space;}
    /**
     * Getting the cost of the Property.
     * @return the cost
     */
    public int getPrice() {
        return cost;
    }
    /**
     * Getting the rent of the Property.
     * @return the rent
     */
    public int getRent() {
        return rent;
    }
    /**
     * Checking if the Property is owned.
     * @return true if the Property is owned, false otherwise
     */

    public boolean isOwned() {
        if (owner == 0) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * Getting the type of the Property.
     * @return the type
     */
    public int getType(){
        return type;
    }
}

