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
        money = 100000;
    }
    /**
     * This method is used receive and get  money to the game banker.
     * @param amount
     */
    public void setAmount(final int amount) {
        money += amount;
    }
    /**
     * This method is used to get the money.
     * @return the money.
     */
    public  int getMoney() {
        return money;
    }
}

