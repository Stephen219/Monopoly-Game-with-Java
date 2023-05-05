package com.cm6123.monopoly.app;
import com.cm6123.monopoly.dice.Dice;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Property;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

import static com.cm6123.monopoly.app.TakeTurns.takeTurn;
import static com.cm6123.monopoly.game.Board.createProperties;
import static java.lang.System.in;




public final class Application {
    /**
     * Create a logger for the class.
     */
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    private Application() {}
    /**
     * Sets the names of the players.
     * @param players the players to set the names for.
     * @param in the scanner to use to get the INPUTs from the user.
     */
    public static void setPlayerNames(final ArrayList<Player> players, final Scanner in) {
        System.out.println(players.size() + " players");

        //iterates through all the players and asks for their names from the user(s)
        for (Player p : players) {
            System.out.print("Enter a name for " + p.getName() + ": ");
            p.setName(in.nextLine());
        }
    }
    /**
     * main entry point.  If args provided, result is displayed and program exists. Otherwise, user is prompted for
     * input.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {


        logger.info("Application Started with args:{}", String.join(",", args));

        System.out.println("Hello. Welcome to Monopoly.");
        ArrayList<Player> players = new ArrayList<Player>();//creates an arraylist of players
        Player player1 = new Player("Player 1", Player.DOG);players.add(player1);
        Player player2 = new Player("Player 2", Player.BATTLESHIP);players.add(player2);
        Player player3 = new Player("Player 3", Player.CAR);players.add(player3);
        Player player4 = new Player("Player 4", Player.HAT);players.add(player4);
        //i can add more players if needed
        setPlayerNames(players, new Scanner(in));
        ArrayList<Property> properties = new ArrayList<Property>();//creates an arraylist of properties
        createProperties(properties);//creates the board with the properties. the class is in the board class.

        boolean gameOver = false; // sets the game to not be over
        int counter = 0;

        Scanner scanner = new Scanner(System.in);
        Dice dice = new Dice(6);

        do { // do-while loop to keep the game going until there is only one player left
            scanner.nextLine();
            takeTurn(players.get(counter), dice, properties, players, scanner);
            scanner.nextLine();
            counter++;
            if (counter > players.size() - 1) {
                counter = 0;
            }

            if (players.size() == 1) { // if there is only one player left in the game then they are the winner
                Player winner = players.get(0);
                Property[] mProperties = winner.getPropertiesArray().toArray(new Property[0]);
                int totalPrices = (int) 0.0; // total price of the properties
                for (Property property : mProperties) {
                    totalPrices += property.getPrice();
                }
                System.out.println("The winner is " + winner.getName() + " with £" + winner.getMoney() + " and the following properties: " + winner.getPropertiesArray());
                System.out.println("Total prices of properties: " + totalPrices + " hence they have a net worth of £" + (totalPrices + winner.getMoney()));
                System.out.println("The game is over.");
                gameOver = true; // set gameOver to true to exit the do-while loop
            }
        } while (!gameOver); // while gameOver is false, keep looping

        scanner.close(); // close the scanner

        logger.info("Application closing");
    }


}
