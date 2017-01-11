
import java.util.Scanner;
import java.util.Random;

/**
 * The following code simulates the Casion Craps game. It is "procedural" and
 * incomplete. Analyse it and develop UML Activity diagrams to explain the flow
 * of execution and the processes required to program the game in computer
 * source-code.
 * 
* Casino Craps (Basic Game) explanation: The game of “craps” is commonly played
 * in Casino’s.
 * 
* Generally, the game works as follows: A player rolls two dice (each with 6
 * possible values, 1 – 6). After rolling the two dice, the sum of the scores
 * are added. If the sum is 7 or 11 on the first throw, the player wins.
 * 
* If the sum is 2, 3 or 12 on the first throw – it is called “craps” and the
 * player loses.
 * 
* If the sum is any of the remaining values (4, 5, 6, 8, 9 or 10) this is
 * called the players “point” (or "point-value").
 * 
* Rolling a point-value gives the player a chance to roll again. They can win
 * the game if they roll their point-value; however, if they roll a 7 first
 * (i.e. before rolling their “point”) they lose.
 * 
* The player can keep rolling until they roll their “point” (in which case they
 * win), or they roll a 7 (in which case they loose).
 * 
****Casino Craps Example Game*** See (http://tinyurl.com/c5ja2qs) and click on
 * the ‘Card & Table Games’ link – and choose ‘Craps’ game. IMPORTANT: CCT holds
 * no liability for any losses incurred should you choose to gamble real money
 * in any way. We highly recommend that you do NOT gamble real money, in any
 * way, as you will most likely lose it.
 * 
*/
public class CasinoCraps {

    static boolean firstTime = true;
    static boolean craps = false;
    static boolean playPointGame = false;
    static int credits = 10;	//example 10credits to start
    static int userDice = 0;

    public static void main( String[] args ) 
    {
        //WELCOME
        System.out.println( "Welcome" );

        do 
        {
            askIfLikeToPlay();
            printCredits();
            askPlayerToRoll();
            int rolled = rollDice();
            System.out.println( "You rolled: " + rolled );
            checkPlayPointGame( rolled );
            
            if ( playPointGame ) 
            {
                playPointGame();
                
            } else {
                
                playCraps();
                
            }

        } while ( !craps ); //craps = false
        
        System.out.println( "Out of do-while loop !" );
    }

    static void playCraps() 
    {
        System.out.println( "do - play craps code" );
        System.out.println( "You loose!" );
        credits -= 5;
        printCredits();
        playPointGame = false;
        firstTime = false;
        craps = true;
        
    }

    static void playPointGame()
    {
        System.out.println( "Simulating rolls ... " );
        simulateWinOrLoose();
    }

    static void checkPlayPointGame( int rolled ) 
    {
        if ( rolled == 7 || rolled == 11 ) 
        {
            System.out.println( "You win!" );
            credits += 5;
            printCredits();
            craps = true;
            playPointGame = false;
            firstTime = false;

        } else if ( rolled == 2 || rolled == 3 ) 
        {
            System.out.println( "You loose!" );
            credits -= 5;
            printCredits();
            craps = true;
            playPointGame = false;
            firstTime = false;

        } else if ( rolled == 12 ) 
        {
            System.out.println( "You loose!" );
            credits -= 5;
            printCredits();
            craps = true;
            playPointGame = false;

        } else {
            craps = false;
            playPointGame = true;
            firstTime = false;
        }

    }

    static int rollDice() 
    {
        Random random = new Random();
        int die1 = random.nextInt( 6 ) + 1;
        int die2 = random.nextInt( 6 ) + 1;
        int rolled = die1 + die2;
        userDice = rolled;
        return rolled;
    }

    static void printCredits() 
    {
        System.out.println( "Credits: " + credits );
    }

    static void askPlayerToRoll()
    {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Press Enter to Roll" );
        String userInput = scanner.nextLine();

        if ( userInput.equals( "" ) )
        {

        } else {
            System.out.println( "quitting..." );
            System.exit( -1 );
        }
    }

    static void askIfLikeToPlay() //definition
    {
        if ( firstTime )
        {
            System.out.println( "play" );
            firstTime = false;
            
        } else 
        {
            System.out.println( "play again" );
        }
    }

    static void simulateWinOrLoose()
    {
        Random rnd = new Random();
        int r = rnd.nextInt(11) + 1;

        if ( r == userDice ) 
        {
            System.out.println( "Simulated Win " + r + " is equal to " + userDice );
            credits += 5;
            firstTime = true;

        } else if ( r == 7 )
        {
            System.out.println( "Simulated Loose " + r + " is equal to 7! " );
            System.out.println( "Setting craps to true" );
            craps = true; //set craps boolean to true
            System.out.println( "game will now end..."  );
            
        }else {
            
            System.out.println();
            
        }
        
    }
   
    
}
