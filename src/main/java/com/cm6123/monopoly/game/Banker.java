package com.cm6123.monopoly.game;

public class Banker {
    /**
     * This is the money of the banker.
     */
    private  int money;
    /**
     * This is the constructor of the banker.
     */
    public Banker() {
        this.money = 100000;
    }
    /**
     * This method is used receive and get  money to the game banker.
     * @param amount the amount of money.
     * the amount of money can be negative or positive depending on the situation.
     *if the amount is negative then the banker is giving money to the player.
     * if the amount is positive then the banker is receiving money from the player
     */
    public void setAmount(final int amount) {
        money += amount;
    }
    /**
     * This method is used to get the money.
     * @return money the money.
     */
    public  int getMoney() {
        return money;
    }
}

