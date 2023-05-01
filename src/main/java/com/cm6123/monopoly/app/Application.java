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
     *
     * @param players the players to set the names for.
     * @param in      the scanner to use to get the names from the user.
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
        ArrayList<Player> players = new ArrayList<Player>();
        Player player1 = new Player("Player 1", Player.DOG);players.add(player1);
        Player player2 = new Player("Player 2", Player.BATTLESHIP);players.add(player2);
        Player player3 = new Player("Player 3", Player.CAR);players.add(player3);

        setPlayerNames(players, new Scanner(in));
        ArrayList<Property> properties = new ArrayList<Property>();
        createProperties(properties);

        boolean gameOver = false;
        int counter = 0;



        Scanner scanner = new Scanner(System.in);
        Dice dice = new Dice(6);

        do {
            scanner.nextLine();
            takeTurn(players.get(counter), dice, properties, players, scanner);
            scanner.nextLine();
            counter++;
            if (counter > players.size() - 1) {
                counter = 0;
            }
        } while (!gameOver);

        scanner.close();



        logger.info("Application closing");
    }


}
