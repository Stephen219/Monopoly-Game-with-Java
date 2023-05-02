package com.cm6123.monopoly.game;

import java.util.ArrayList;

/**
 * this is a player class with all the methods and attribute for the player.
 */
public class Player {
    /**
     * Represents wheelbarrow the piece.
     */
    public static final int CAT = 0;
    /**
     * Represents battleship the piece.
     */
    public static final int BATTLESHIP= 1;
    /**
     * Represents sack of money the piece.
     */
    public static final int DOG= 2;
    /**
     * Represents horse and rider the piece.
     */
    public static final int CAR = 3;
    /**
     *arraylist of properties owned by the player in the game.
     */
    private final ArrayList<Property> playerProperties;

    /**
     * Represents the name.
     */
    private String name;
    /**
     * Represents the piece.
     */

    private final int  whichPiece;
    /**
     * Represents the space.
     */
    private int space;
    /**
     * Represents the money.
     */
    private int money;
    /**
     * Represents the doubles.
     */
    private int doubles;
    /**
     * Represents the properties.
     */
    private int properties;
    /**
     * creating a constructor for a player with no any value.
     * this is used to create an unknown player.
     */
    public Player() {
        name       = new String("UNKNOWN");
        whichPiece = 0;
        space      = 0;
        money      = 1000;
        doubles    = 0;
        properties = 0;
        this.playerProperties= new ArrayList<Property>();
    }
    /**
     * This is the constructor of the Player class where the name and the piece are passed.
     * @param playerName is the name of the player
     * @param piece is the piece of the player
     */
    public Player(final String playerName, final int piece) {
        name       = playerName;
        whichPiece = piece;
        space      = 0;
        money      = 1000;
        doubles    = 0;
        properties = 0;
        this.playerProperties= new ArrayList<Property>();
    }
    /**
     * this is the method that adds a property to the player.
     * @param property is the property to be added
     */
    public void addProperty(final Property property) {
        playerProperties.add(property);
    }

    /**
     * this is the method that returns the properties owned by the player.
     * @return the properties owned by the player
     */
    public ArrayList<Property> getPropertiesArray() {
        return playerProperties;
    }
    /**
     * Getting the mane of the Player.
     * @return the name of the Player.
     */
    public String getName() {
        return name;
    }
    /**
     * Changing the name of the Player.
     * @param n the new name of the Player
     */
    public void setName(final String n) {
        name = n;
    }
    /**
     * Getting the piece  of the Player.
     * @return the whichpiece of the Player.
     */
    public int getPiece() {
        return whichPiece;
    }
    /**
     * Getting the money  of the Player.
     * @return the money garnrerd of the Player.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Getting the doubles  of the Player.
     * @return the doubles of the Player.
     */
    public int getDoubles() {
        return doubles;
    }
    /**
     * Can either add or subtract from a Player's amount.
     *   of money (a positive number adds, a negative subtracts)
     * @param value how much money to add or subtract
     */
    public void setMoney(final int value) {
        money += value;
    }
    /**
     * Returning the properties of a player.
     * @return the properties
     */
    public int getProperties() {
        return properties;
    }
    /**
     * Resets the number of times a Player.
     *   has rolled doubles to 0
     */
    public void resetDoubles() {
        doubles = 0;}
    /**
     * Adds 1 to the number of times the Player has rolled doubles.
     */
    public void addDoubles() {
        doubles++;}
    /**
     * geting the space of the Player.
     * @return the space
     */
    public int getSpace() {
        return space;
    }
    /**
     * Sets the current space of the Player.
     * @param location the new space of the Player
     */
    public void setSpace(final int location) {
        space = location;
    }
    /**
     * this is the method that moves the player from one position.
     * @param rolled is the roled number
     */
    public void movePiece(final int rolled) {
        space += rolled;
        if (space > 15) {
            space %= 16;
            setMoney(200);
        }
    }
    /**
     * add a property when they buy.
     */
     void addProperty() {
        properties += 1;
    }/**
     * this is the method that sells the properties.
     * and subtracts it from the current properties
     * @param prop3 is the property
     * @return true if the player has enough money to buy the property
     */
    public boolean buyProperty(final Property prop3) {
        if (money >= prop3.getPrice()) {
            money -= prop3.getPrice();
            addProperty();
            return true;
        }else {
            return false;
        }
    }
    /**
     * this is the method that sells the properties.
     * and subtracts it from the current properties
     */
    public void sellProperty() {
        properties -= 1;
    }
}
