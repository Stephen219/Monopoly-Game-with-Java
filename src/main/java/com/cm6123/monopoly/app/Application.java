package com.cm6123.monopoly.app;
import com.cm6123.monopoly.dice.Dice;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

import static com.cm6123.monopoly.game.Board.createProperties;
import static java.lang.System.in;


public final class Application {
    /**
     * Create a logger for the class.
     */
    private static Logger logger = LoggerFactory.getLogger(Application.class);


    private Application() {}
    public static void setPlayerNames(final ArrayList<Player> players, final Scanner in) {
        System.out.println(players.size() + " players");

        //iterates through all the players and asks for their names from the user(s)
        for (Player p : players) {
            System.out.print("Enter a name for " + p.getName() + ": ");
            p.setName(in.nextLine());
        }
    }
    public static void takeTurn(Player player, Dice dice){
        // Roll the die
        int roll1 = dice.roll();
        int roll2 = dice.roll();
        int rollTotal = roll1 + roll2;
        // Print the roll result
        System.out.println(player.getName() + " rolls " + roll1 + " and " + roll2 + " for a total of " + rollTotal);
        // Move the player's piece
        player.movePiece(rollTotal);
        int curr= player.getSpace();
        int money= player.getMoney();
        System.out.println(player.getName() + " is now on " + curr);
        System.out.println(player.getName() + " has $" + money);
        // Check if the player passed Go
        if (player.getSpace() >= 16) {
            System.out.println(player.getName() + " passed 'Home' and received $200");
            player.setMoney(player.getMoney() + 200);
            player.setSpace(player.getSpace() - 16); // Move the player back to the beginning
        }
        // Check if the player passed the tax office
        if (player.getSpace() == 10) {
            System.out.println(player.getName() + " landed on the tax office and will pay 10% of their money");
            int tax = (int) Math.round(0.1 * player.getMoney());
            player.setMoney(player.getMoney() - tax);
            System.out.println(player.getName() + " paid $" + tax + " in taxes and now has $" + player.getMoney());
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
                takeTurn(player, dice); // Recursively call takeTurn() method to roll again
            }
        } else {
            player.resetDoubles();
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
        Player player1 = new Player("Player 1", Player.CAR);players.add(player1);
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
            takeTurn(players.get(counter), dice);
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
