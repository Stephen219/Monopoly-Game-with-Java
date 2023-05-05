package com.cm6123.monopoly.app;

import com.cm6123.monopoly.dice.Dice;
import com.cm6123.monopoly.game.Banker;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Property;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.cm6123.monopoly.app.RemovePlayer.removePlayer;

public final class TakeTurns {
    /**
     * This is the constructor of the class.
     * Private constructor to prevent instantiation of the TakeTurns class.
     * This class is a utility class and should not be instantiated.
     */
    private TakeTurns() {}
    /**
     * This is the banker of the game.
     */
    private static Banker banker = new Banker();
    /**
     * This is the main method of the game. with the user interfaces and the game logic.
     * @param player the player
     * @param dice the dice
     * @param properties the properties
     * @param players the players
     * @param scan the scanner
     */
    public static void takeTurn(final Player player, final Dice dice, final ArrayList<Property> properties,final ArrayList<Player> players,final  Scanner scan) throws InputMismatchException {
        // Roll the dice. encapsulate this in a try catch block catch any exceptions and print a message
        try {
            int roll1 = dice.roll();
            int roll2 = dice.roll();
            int rollTotal = roll1 + roll2;
            int spaceBefore = player.getSpace();//get the space before the roll
        if (spaceBefore + rollTotal > 16) {
            banker.setAmount(-200);  //bankk give money to player if he pass go
            System.out.println("You have passed go and collected £200");
        }
        // Print the roll result
        System.out.println(player.getName() + " rolls " + roll1 + " and " + roll2 + " for a total of " + rollTotal);
        // Move the player's piece
        player.movePiece(rollTotal);
        int curr = player.getSpace();//get the space after the roll
        System.out.println(properties.get(curr));
        Property property = properties.get(player.getSpace()); //get the property in the current space
        int money = player.getMoney();//get the money of the player
        System.out.println(player.getName() + " is now in space " + curr);
        System.out.println(player.getName() + " has £" + money);
        // Check if the player landed on a road
        if (property.getType() == 2) { // road are of type 2
            System.out.println("You have landed on a road." +property.getName()+ " No action is required.");
        }
        // Check if the player landed on a buyable and sellable property
        if (property.getType() == 0) { // buyable and sellable properties are of type 0
            if (!property.isOwned()) {
                // Property is not owned by anyone, ask player if they want to buy it
                System.out.println(player.getName() + " landed on " + property.getName() + ", which is available for purchase for £" + property.getPrice() + ".");
                System.out.print("Would you like to buy it? (Y/N): "); //ask the player if he wants to buy the property
                String answer = scan.next();
                if (answer.equalsIgnoreCase("Y")) {
                    if (player.buyProperty(property)) {
                        banker.setAmount(property.getPrice());//banker takes the money from the player
                        System.out.println("bank has £" + banker.getMoney());
                        int playerIndex = players.indexOf(player);//get the index of the player
                        property.setOwner(playerIndex); //set the owner of the property
                        //aad the property to the player's arraylist
                        player.addProperty(property);
                        //print the properties owned by the player
                        ArrayList<Property> aProperties = player.getPropertiesArray();
                        System.out.println(player.getName() + " owns the following properties:");
                        if (aProperties.isEmpty()) {
                            System.out.println("None");
                        } else {
                            for (Property aProperty : aProperties) {
                                System.out.println(aProperty.getName() + " - $" + aProperty.getPrice());
                            }
                        }
                        System.out.println(player.getName() + " has purchased " + property.getName() + " for £" + property.getPrice() + "and now has £" + player.getMoney() + " left.");
                        System.out.println("they own "+player.getProperties()+" properties");
                    } else{
                        // TOD O: 03/05/2023   the player can sell the property.
                        // Player does not have enough money to buy the property
                        System.out.println(player.getName()+ " does not have enough money to buy " + property.getName() +  "since they have £" + player.getMoney() + " left.");
                    }
                }
            } else if (property.getOwner() == player.getPiece()) {
                // Player already owns the property they can choose to sell it.
                System.out.println(player.getName() + " already owns " + property.getName() + ".");
                System.out.println("Do you want to sell " + property.getName() + " for " + property.getPrice() + "? (Y/N)");
                String input = scan.nextLine().toUpperCase();
                if (input.equals("Y")) {
                    //player can sell the property they own if they land on it
                    banker.setAmount(-property.getPrice());
                     player.setMoney(property.getPrice());
                    player.sellProperty();
                    property.setOwner(0);
                    System.out.println("Sold " + property.getName() + " for " + property.getPrice() + "they now have £" + player.getMoney() + " left.");
                }else if (!input.equals("N")) {
                    throw new InputMismatchException("Invalid input. Please enter Y or N."); //if the player enters an invalid input
                }
            }else {
                // Property is owned by someone else, player needs to pay rent
                int rent = property.getRent();
                Player owner = players.get(property.getOwner());
                System.out.println(player.getName() + " landed on " + property.getName() + ", which is owned by " + owner.getName() + ".");
                System.out.println(player.getName() + " pays £" + rent + " in rent.");
                player.setMoney(- rent);
                owner.setMoney(rent);
            }
        }
        // Check if the player landed on a tax office it is of type 3 and box 10
        if (property.gettingSpace() == 10) {
            System.out.println(player.getName() + " landed on the tax office.");
            if (roll1 == roll2) { //if the player rolls a double he pays a discounted tax
                int discountedTax = (int) Math.round(0.05 * player.getMoney());
                banker.setAmount(discountedTax);
                System.out.println("the banker has £" + banker.getMoney());
                player.setMoney(- discountedTax);//player pays the discounted tax
                System.out.println(player.getName() + " rolled a double and paid a discounted tax of £" + discountedTax + ". They now have £" + player.getMoney());
            } else{ //if the player does not roll a double he pays the full tax
                int tax = (int) Math.round(0.1 * player.getMoney());
                int moneyToPaye = player.getMoney() - tax;
                System.out.println("payed " + tax + " in tax);" + "money left " + moneyToPaye);
                player.setMoney(-tax);
                banker.setAmount(tax);
                System.out.println("the banker has £" + banker.getMoney());
                System.out.println(player.getName() + " did not roll a double and paid £" + tax + " in taxes. They now have £" + player.getMoney());
            }
        }
        // Check if the player landed on a station
        if (property.getType() == 1) { //stations are of type 1
            int ticketPrice = 10 * rollTotal; //ticket price is 10 times the total of the dice
            System.out.println(player.getName() + " landed on a station and will pay £" + ticketPrice + " to the banker");
            player.setMoney(- ticketPrice);
            banker.setAmount(ticketPrice);
            System.out.println("the banker has £" + banker.getMoney());
            System.out.println(player.getName() + " paid £" + ticketPrice + " and now has £" + player.getMoney());
        }
        // Check if the player rolled doubles
        if (roll1 == roll2) {
            player.addDoubles();
            if (player.getDoubles() == 3) {
                // Player has rolled doubles three times in a row
                System.out.println(player.getName() + " rolled doubles three times in a row and goes to the nearest property");
                player.setSpace(1); // Move the player to the nearest property
                player.resetDoubles();
            } else {
                // Player rolls again
                System.out.println(player.getName() + " rolled doubles and gets to roll again");
                takeTurn(player, dice, properties, players, scan); // Recursion of the takeTurn method
            }
        } else {
            player.resetDoubles(); // Reset the doubles counter
        }
        removePlayer(player, players, properties, banker); // Check if the player is bankrupt and remove them from the game if they are
    }catch (Exception e) { //catches any exception
        if (e instanceof InputMismatchException) {
            System.out.println("Invalid input!!. Please enter a valid input!!.");
        } else {
            System.out.println("mmmmmh!!! .An error occurred.Please press enter to continue......");
        }
        //e.printStackTrace();
    }
//        if (players.size() == 1) {//if there is only one player left in the game then thy are the winner
//            Player winner = players.get(0);
//            Property[] mProperties = winner.getPropertiesArray().toArray(new Property[0]);
//            int totalPrices = (int) 0.0; //total price of the properties
//            for (Property property : mProperties) {
//                totalPrices += property.getPrice();
//            }
//            System.out.println("The winner is " + winner.getName() + " with £" + winner.getMoney() +"and the following properties: " + winner.getPropertiesArray());
//            System.out.println("Total prices of properties: " + totalPrices + "hence they has a net worth of £" + (totalPrices + winner.getMoney()));
//            System.out.println("The game is over.");
//        }
    }
}
