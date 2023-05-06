package com.cm6123.monopoly.game;
import java.util.ArrayList;
import java.util.Map;

/**
 * this is a player class with all the methods and attribute for the player.
 */
public class Player {
    /**
     * Represents the number of pieces in the game.
     * not that essential but i included it anyway.
     */
    /**
     * Represents cat  piece.
     */
    public static final int CAT = 0;
    /**
     * Represents battleship piece.
     */
    public static final int BATTLESHIP= 1;
    /**
     * Represents dog  piece.
     */
    public static final int DOG= 2;
    /**
     * Represents car  piece.
     */
    public static final int CAR = 3;
    /**
     * represents the hat.
     */
    public static final int HAT = 4;
    /**
     * Represents the bo0t.
     */
    public static final int BOOT = 5;
    /**
     * Represents the iron.
     */
    public static final int IRON = 6;
    /**
     * Represents the  thimble.
     */
    public static final int THIMBLE =7;
    /**
     * Represents the train.
     */
    public static final int TRAIN = 8;
    /**
     * Represents the sack of money.
     */
    public static final int SACK_OF_MONEY=9;
    /**
     * Represents the horse and rider.
     */
    public static final int HORSE_AND_RIDER =9;
    /**
     * Represents the cannon.
     */
    public static final int WHEELBARROW =10;
    /**
     * Represents the cannon.
     */
    public static final int CANNON =11;
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

    private int  whichPiece;
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
     * A map containing the names of the Monopoly pieces to be used in the game.
     * The key is an integer representing the piece, and the value is a string with the piece's name.
     */
    private static final Map<Integer, String> PIECE_NAMES = Map.of(
            BATTLESHIP, "Battleship",
            CANNON, "Cannon",
            CAR, "Car",
            HAT, "Hat",
            BOOT, "Boot",
            IRON, "Iron",
            THIMBLE, "Thimble",
            TRAIN, "Train",
            HORSE_AND_RIDER, "Horse and Rider",
            WHEELBARROW, "Wheelbarrow"
    );
    /**
     * this is the method that returns the name of the piece of the player.
     * @return the name of the piece
     */
    public String getPieceName() {
        return PIECE_NAMES.get(whichPiece);
    }
    /**
     * Creating a standard Player object with a specified name.
     * @param n is the name of the Player
     * the other attributes are set to default values
     */
    public Player(final String n) {
        name       = n;
        whichPiece = 0;
        space      = 0;
        money      = 1000;
        doubles    = 0;
        properties = 0;
        this.playerProperties= new ArrayList<Property>();
    }
    /**
     * creating a constructor for a player with no any value.
     * this is for the default player.
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
     * Getting the money  of the Player.
     * @return the money garnrerd of the Player.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Getting the doubles  of the player.
     * @return the doubles of the player.
     */
    public int getDoubles() {
        return doubles;
    }
    /**
     * * Can either add or subtract from a player's amount of money.
     * (a positive number adds, a negative subtracts)
     * @param value how much money to add or subtract
     */
    public void setMoney(final int value) {
        money += value;
    }
    /**
     * Returning the number of properties of a player.
     * @return the properties
     */
    public int getProperties() {
        return properties;
    }
    /**
     * Resets the number of times a player.
     *   has rolled doubles to 0
     */
    public void resetDoubles() {
        doubles = 0;}
    /**
     * Adds 1 to the number of times the player has rolled doubles.
     */
    public void addDoubles() {
        doubles++;}
    /**
     * geting the space of the player.
     * @return the space
     */
    public int getSpace() {
        return space;
    }
    /**
     * Sets the current space of the player.
     * @param location the new space of the player
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
     * this is the method that buys the properties.
     * and subtracts it from the current properties
     * @param prop3 is the property
     * @return true if the player has enough money to buy the property
     */
    public boolean buyProperty(final Property prop3) {
        if (money >= prop3.getPrice()) {
            money -= prop3.getPrice();
            properties += 1;
            playerProperties.add(prop3);
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
    /**
     * Changing a Player's piece.
     * @param piece the new piece
     * @see static variables for piece options
     */
    public void setPiece(final int piece) {
        whichPiece = piece;
    }}


