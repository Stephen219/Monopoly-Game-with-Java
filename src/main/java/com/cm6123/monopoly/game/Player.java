package com.cm6123.monopoly.game;
/**
 * this is a player class with all the methods and attributes needed to play the game.
 */
public class Player {
    /**
     * Represents wheelbarrow the piece.
     */
    public static final int WHEELBARROW      = 0;
    /**
     * Represents battleship the piece.
     */
    public static final int BATTLESHIP       = 1;
    /**
     * Represents sack of money the piece.
     */
    public static final int SACK_OF_MONEY    = 2;
    /**
     * Represents horse and rider the piece.
     */
    public static final int HORSE_AND_RIDER  = 3;

    /**
     * Represents the name.
     */
    private String name;
    /**
     * Represents the piece.
     */

    private int whichPiece;
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

    public Player(final String playerName, final int piece) {
        name       = playerName;
        whichPiece = piece;
        space      = 0;
        money      = 1000;
        doubles    = 0;
        properties = 0;
    }
    /**
     * Getting the mane of the Player.
     * @return the name of the Player.
     */
    public String getName() {
        return name;
    }

}
