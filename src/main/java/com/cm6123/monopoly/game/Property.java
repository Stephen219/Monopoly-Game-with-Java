package com.cm6123.monopoly.game;
/**
 * This class represents the properties in the game.
 * The properties are the spaces on the board that can be bought by the players.
 * The properties are of types: home, buyable, station, road, and tax office.
 * The properties have a name, owner, colour group, cost, rent, space, and type.
 */
public class Property {
    /**
     * Repreesents the home property type.  can either be a station, road, or tax office.
     */
    public static final int OTHER = -1;// this is not part of the attributes of the property
    /**
     * Represents the types of properties that can be bought.
     */
    public static final int PROPERTY = 0;// this is not part of the attributes of the property
    /**
     * represents the station properties.
     */
    public static final int STATION = 1;// this is not part of the attributes of the property
    /**
     * represents the road properties.
     */
    public static final int ROAD = 2;// this is not part of the attributes of the property
    /**
     * represents the tax office property.
     */
    public static final int TAXOFFICE = 3; // this is not part of the attributes of the property
    /**
     * Represents the name of the property.
     */
    private final String name;
    /**
     * Represents the owner of the property.
     */
    private String owner;
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
     * Represents the space of the property on the board.
     */
    private final int space;
    /**
     * Represents the type of the property.
     * either home of type -1, buyable of type 0, station of type 1, road of type 2, or tax office of type 3.
     */
    private int type;

    /**
     * Creating a default constructor for the Property class, which sets default values for name, owner, colourGroup, cost,
     * rent, and space. This constructor is used when a Property object is created without any parameters hence default are set.
     */
    public Property() {
        this.name = "UNDEFINED";
        this.owner = null;
        this.colourGroup = "NONE";
        this.cost = 0;
        this.rent = 0;
        this.space = 0;
    }

    /**
     * Creating a constructor for the Property class, which sets values for name, owner, colourGroup, cost, rent, and space.
     * This constructor is used when a Property object is created with parameters.
     *
     * @param propertyname        is the name of the Property
     * @param proprtyOwner        is the owner of the Property
     * @param propertyType        is the value of a parameter that is not currently being used
     * @param propertyColourGroup is the colour group of the Property
     * @param propertyCost        is the cost of the Property
     * @param propertyRent        is the rent of the Property
     * @param propertySpace       is the space where the Property is located
     */
    protected Property(final String propertyname, final String proprtyOwner, final int propertyType, final String propertyColourGroup, final int propertyCost, final int propertyRent, final int propertySpace) {
        this.name = propertyname;
        this.owner = proprtyOwner;
        this.colourGroup = propertyColourGroup;
        this.cost = propertyCost;
        this.rent = propertyRent;
        this.space = propertySpace;
        this.type = propertyType;
    }
    /**
     * Getting the name of the Property.
     *
     * @return the name of the Property
     */
    public String getName() {
        return name;
    }

    /**
     * Getting the index of the Player who owns the Property.
     * @return the index of the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Changing the owner of the Proerty.
     * @param o is the index of the new owner
     */
    public void setOwner(final String o) {
        owner = o;
    }

    /**
     * Getting the colour group of the Property.
     *
     * @return the colour group
     */
    public String getColourGroup() {
        return colourGroup;
    }

    /**
     * Getting the space where the Property is located of the Property.
     *
     * @return the space
     */
    public int gettingSpace() {
        return space;
    }

    /**
     * Returning all relevant values about a Property.
     *
     * @return the values of a property
     */
    public String toString() {
        return "PROPRERTY: <" + name + ">\n"
                + "(*)Owner = " + owner + "\n"
                + "(*)Colour Group = " + colourGroup + "\n"
                + "(*)Cost = " + cost + "\n"
                + "(*)Rent = " + rent + "\n"
                + "(*)Space = " + space;
    }

    /**
     * Getting the cost of the Property.
     *
     * @return the cost
     */
    public int getPrice() {
        return cost;
    }

    /**
     * Getting the rent of the Property.
     *
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
        return owner != null ? true : false;
    }
    /**
     * Getting the type of the Property.
     * @return the type
     */
    public int getType() {
        return type;
    }
}

