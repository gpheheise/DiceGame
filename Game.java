/**
 * This is the game class of the 2 player dice game. It runs the Game!
 * 
 *  @author Georg Philipp Erasmus Heise 
 *  @ SSID = 25912704 
 *  gphei2@student.monash.edu
 *  twitter = @gpheheise
 *  @version 1.0.3
 *  
 *  game constructor 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game
{

        
    // Number of player to play the game
    int playerCount = 2;
        
    // Player array to dynamically adjust player
    private Player[] players = new Player[playerCount];
        
    // State whether players are setted up
    private boolean settedUp= false,
    // State whether game is finished
        finished = false,   
    // State whether result was a draw
        draw = false; 
        
    // Instance of Dice for generating random number
    private Dice dice = new Dice();
        
    // List of players whose position is above 50 
    private List<Player> list = new ArrayList<Player>();
        
    /**
     * Methode used to display menu
     */
    protected void displayMenu ()
    {
        println("Welcome to the Simple Board Game");
        println("================================");
        println("(1) Start a New Game");
        println("(2) Play One Round");
        println("(3) Display Players' Positions");
        println("(4) Display Game Help");
        println("(5) Exit Game");
        System.out.print("Choose an option : ");
            
        try 
        { //try and catch is used to fetch input errors and directly detect them
            Scanner scanner = new Scanner(System.in);
            String schoice = scanner.next();
            int ichoice = Integer.parseInt(schoice); 
            options(ichoice);
        } 
        catch (Exception e) 
        {
            err();
        } 
        finally 
        {
            System.out.print("\n");
            displayMenu();
        }
    }

    /**
     * Displays help menu
     */
    private void displayHelp() 
    {
        
        println("");
        println("===================================================");
        println("=                                                 =");
        println("=         HH  HH   EEEEE  LL     PPPPPP           =");
        println("=         HH  HH   EE     LL     PP  PP           =");
        println("=         HH  HH   EE     LL     PP  PP           =");
        println("=         HHHHHH   EEEE   LL     PPPPPP           =");
        println("=         HH  HH   EE     LL     PP               =");
        println("=         HH  HH   EEEEE  LLLLL  PP               =");
        println("=                                                 =");
        println("===================================================");
        println("=  This is a simple two player dice game          =");
        println("=                                                 =");
        println("=-------------------------------------------------=");
        println("=  To play two players start a game  by           =");
        println("=  entering their names.                          =");
        println("=  as soon as the game starts both players        =");
        println("=  players throw the dice round by round          =");
        println("=  until one of the players reached 50 points     =");
        println("=  as soon as someone hits a magic feld he/she    =");
        println("=  will get penilized and moved backwars by       =");
        println("=  5 fields                                       =");
        println("=  Iff both players reach over 50 points a draw   ="); 
        println("=  happend.                                       ="); 
        println("=                                                 ="); 
        println("---------------------------------------------------");
        println("=  fixed terms:                                   =");                           
        println("=  the dice has 6 sides                           =");
        println("=  currently 2 players are playing                =");
        println("=  moving back 5 fields when hitting a magic feld =");
        println("=  magic felds are : 11, 22, 33, 44`              =");
        println("===================================================");
    }

    /**
     * Displays players' position
     */
    private void displayPlayerPosition() 
    {
        // Utilisation of foreach
        for (Player player : players)
            println("Player ".concat(player.getName()).concat(" is on position ").concat(Integer.toString(player.getPosition())));  //using concat instead of + since this is a better way of 
                                                                                                                                    //attaching strings together and not filling up the memory unnecessarily
    }
        



     /**
     * Prints errors
     * @param Exception which occurred
     * recieved help from friend Thomas Kosiewski that only numbers between 1-5 will work
     */
    private void err ()
    {
        System.out.println("\nPlease enter a number between 1 and 5");
    }    

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        
    }

    
    /**
     * Create an instance of the Game and start it
     * 
     */
    public static void main (String[] args)
    { 
        try 
        {
            new Game().start();
        } 
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
    
        /**
     * Evaluates user's input
     * @param number input by user
     */
    public void options(int choice) 
    {
        // Especially not using switch, as switch labels commands
        // The concept of labeling is in modern programming languages outdated and may have harmful results, as seen in apple's "goto fail"
        
        if (choice < 1 || choice > 5) //this if clause checks that entered numbers are between 1 and 5 and if not prints out an error message
            {
                err();
            } 
        
        else 
            if (choice == 1) 
            {
                setUpPlayer();

            } 
        
        else 
            if (choice == 4)
            {
                displayHelp();
            }
        
        else 
            if (choice == 5) 
            {
                System.exit(0);
            } 
        
        else 
            if (!settedUp)
            {
                println("Please set up the players first!");
                setUpPlayer();
            } 
        
        else 
            if (choice == 3)
            {
                displayPlayerPosition();
            }
        
        else 
            if (finished)
            {
                println("Game finished. You must start a new game");
                if (!draw)
                    println("The last game was won by Player ".concat(list.get(0).getName()));  
                else
                    println("The last game was a draw");
            } 
        
        else 
            if (choice == 2)
            {
                rollDice();
            }
    }
    
        /**
     * Prints to console
     * @param String to print
     */
    private void println (String toPrint)
    {
        System.out.println(toPrint);
    }


        /**
     * Emulates dice roll with following evaluation of scores
     */
    private void rollDice() 
    {
        // Utilisation of foreach
        for (Player player: players)
        {
            // Position before dice roll
            int beginning = player.getPosition(),
                // Rolled number
                rolled = dice.rollDice();
                
            // add the rolled number to players position
            player.raisePosition(rolled);
            
            // Player's penalization
            if (player.getPosition() == 11 || player.getPosition() == 22 || player.getPosition() == 33 || player.getPosition() == 44)
                {
                    println("Player ".concat(player.getName()).concat(" had hit a magic feld and had to move 5 felds back"));
                    player.penalize();
                }
            // Output Name beginning and end position
            println(player.getName().concat(" rollead a ").concat(Integer.toString(rolled)).concat(", and moves from position ").concat(Integer.toString(beginning)).concat(" to ").concat(Integer.toString(player.getPosition())));
        }
            
        // Put all players with a position higer than 50 into one list
        for (Player player: players)
            if (player.getPosition() >= 50)
                list.add(player);
            
        // Check if there is already a player in the list, meaning the game is finished
        if (list.size() >= 1)
        {
            // Evaluating the results
            // If list's size equals 1 only one player won the game
            if (list.size() == 1)
            {
                println("Congratulations, " + list.get(0).getName() + " have WON this game.");
                draw = false;
            } 
            // Else if the list is bigger than 1 a draw happend
            else 
                if (list.size() > 1)
                {
                    println("It's a draw");
                    draw = true;
                }
            
            // Game is finished
            finished = true;
        }
    }
    
    /**
     * Methode for first displaying of the menu
     */
    public void start ()
    {
        displayMenu();
    }
    
    
    /**
     * Used to set up new player
     */
    private void setUpPlayer() 
    {
        if (settedUp)
        {
            System.out.print("Do you want start a new game : (Y / N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (response.toLowerCase().equals("n"))return;
        }
        
      
        // Let user dynamically adjust players
        // System.out.print("Enter number of players: ");
        // playerCount = scanner.nextInt();
        // players = new Player[playerCount];
        
        
        // Use of for loop, as arrays shall be filled up with objects of Player
        for (int i = 0; i < players.length; i++)
        {
            try 
            {
                System.out.print("Enter the name for Player #" + ( 1 + i) + ": ");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.next();
                players[i] = new Player(name);
            } 
            catch (Exception e) 
            {
                System.err.println(e.getMessage());
            }
        }
        finished = false;
        settedUp = true;
        draw = false;
        
        
        list.clear();
    }
    
}