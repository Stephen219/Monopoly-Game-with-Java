package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.Banker;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Property;

import java.util.ArrayList;

 public final class RemovePlayer {
     private RemovePlayer() {
     }
    /**
     * This method is used to remove a player from the game if they are bankrupt.
     * @param player the player to be removed.
     * @param players the list of players in the game.
     * @param properties the list of properties in the game.
     * @param banker the banker of the game.
     * @return the winner of the game when the player array list has only one player.
     */
    public static Player removePlayer(final Player player, final ArrayList<Player> players,final ArrayList<Property> properties, final Banker banker) {
        if (player.getMoney() < 0 && player.getPropertiesArray().isEmpty()) { // if player is bankrupt and has no properties
            System.out.println(player.getName() + " is bankrupt and out of the game.");
            players.remove(player); // remove player from game
        } else if (player.getMoney() < 0 && !player.getPropertiesArray().isEmpty()) {
            System.out.println(player.getName() + " has properties and is in debt. They must sell properties to repay debt.");
            ArrayList<Property> playerProperties = player.getPropertiesArray();
            while (!playerProperties.isEmpty() && player.getMoney() < 0) {
                Property propertyToSell = playerProperties.get(0);
                for (Property property : playerProperties) {
                    if (property.getPrice() < propertyToSell.getPrice()) {
                        propertyToSell = property;
                    }
                }
                playerProperties.remove(propertyToSell);
                properties.add(propertyToSell);
                int amoun = (int) (0.5 * propertyToSell.getPrice()); // sell property for half price
                banker.setAmount(-amoun);
                player.setMoney(amoun);
                System.out.println(player.getName() + " sold " + propertyToSell.getName() + " for " + 0.5 * propertyToSell.getPrice());
            }
            if (player.getMoney() >= 0) {
                System.out.println(player.getName() + " has repaid their debt and is still can continue with the game.");
            } else {
                System.out.println(player.getName() + " is bankrupt and out of the game!!!.");
                players.remove(player);
            }
        }
        if (players.size() == 1) {
            // return the winner
            Player winner = players.get(0);
            //System.out.println("The winner is " + winner.getName() + " with £" + winner.getMoney() +"and the following properties: " + winner.getPropertiesArray());
            return players.get(0);
        } else {
            return null;
        }
    }

}
