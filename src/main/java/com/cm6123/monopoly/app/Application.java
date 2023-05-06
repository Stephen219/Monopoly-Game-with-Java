package com.cm6123.monopoly.app;
import com.cm6123.monopoly.dice.Dice;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
     * @param scanner1 the scanner to use to get the INPUTs from the user.
     */
    public static void setPlayerNames(final ArrayList<Player> players,final Scanner scanner1) {
        int numPlayers;
        Scanner scanner = new Scanner(System.in);
        do { // Loop until the user enters a number between 2 and 10
            try {
                System.out.print("Enter the number of players (2-10): ");
                numPlayers = scanner.nextInt();
                if (numPlayers < 2 || numPlayers > 10) {
                    System.out.println("Please enter a number between 2 and 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer value.");
                scanner.nextLine(); // Clear the invalid input from the scanner
                numPlayers = 0; // Set numPlayers to 0 so that the loop will continue
            }
        } while (numPlayers < 2 || numPlayers > 10);
        scanner.nextLine(); // Clear the newline character from the scanner
        for (int i = 0; i < numPlayers; i++) {
            String name;
            do { // Loop until the user enters string  name
                System.out.print("Enter the name of player " + (i + 1) + ": ");
                name = scanner.nextLine().trim();
            } while (name.isEmpty());
            // Create a new player and add it to the list of players
            Player player = new Player(name);
            switch (i % 10 + 1) {//sets the piece for each player
                case 1: player.setPiece(Player.WHEELBARROW); break;
                case 2: player.setPiece(Player.TRAIN); break;
                case 3: player.setPiece(Player.BOOT); break;
                case 4: player.setPiece(Player.CAR); break;
                case 5: player.setPiece(Player.THIMBLE); break;
                case 6: player.setPiece(Player.CANNON); break;
                case 7: player.setPiece(Player.HORSE_AND_RIDER); break;
                case 8: player.setPiece(Player.IRON); break;
                case 9: player.setPiece(Player.HAT); break;
                case 10: player.setPiece(Player.BATTLESHIP); break;
                default: player.setPiece(Player.SACK_OF_MONEY); break;
            }
            players.add(player);//adds the player to the arraylist
        }
    }
    /**
     * Creates the game.
     */
    public static void game(){
        ArrayList<Player> players = new ArrayList<Player>();//creates an arraylist of players
        setPlayerNames(players, new Scanner(in));//sets the names of the players
        players.forEach(player -> System.out.println(player.getName() + " is using the " +  player.getPieceName() + " piece."));
        System.out.println("the number of players is: " + players.size());
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
                System.out.println("The winner is " + winner.getName() + " with £" + winner.getMoney() + " and  " + winner.getPropertiesArray().size()+ " properties  which are as follows: " + winner.getPropertiesArray());
                System.out.println("Total prices of properties: " + totalPrices + " hence they have a net worth of £" + (totalPrices + winner.getMoney()));
                System.out.println("The game is over.");
                gameOver = true; // set gameOver to true to exit the do-while loop
            }
        } while (!gameOver); // while gameOver is false, keep looping
        scanner.close(); // close the scanner
    }
    /**
     * main entry point.  If args provided, result is displayed and program exists. Otherwise, user is prompted forinput.
     * @param args command line args.
     */
    public static void main(final String[] args) {
        logger.info("Application Started with args:{}", String.join(",", args));
        System.out.println("Hello. Welcome to Monopoly.");
        Application.game();
        logger.info("Application closing");
    }
}
