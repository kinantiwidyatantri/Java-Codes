import java.io.*;
import java.util.*;

public class DieGame implements CardDieInterface{
    // The BufferedReader used throughout
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // The random number generator used throughout
    private RandomInterface r = new LinearCongruentialGenerator();

    private HashSet<Integer> numbersRolled = new HashSet<Integer>();
  
    public void initialiseGame() throws Exception {
        // The initialisation phase:
        return;
        // Actually there isn't anything to do here
    }   

    public void mainGame() throws Exception {
        // The main game:

        // Let the user roll the die twice
        for (int i=0; i<2; i++) {
        System.out.println("Hit <RETURN> to roll the die");
        br.readLine();
        int dieRoll=(int)(r.next() * 6) + 1;

        System.out.println("You rolled " + dieRoll);
        numbersRolled.add(Integer.valueOf(dieRoll));
        }

        // Display the numbers rolled
        System.out.println("Numbers rolled: " + numbersRolled);
    }

    public void declareGameWinner() throws Exception {
        // Declare the winner:

        // User wins if at least one of the die rolls is a 1
        if (numbersRolled.contains(Integer.valueOf(1))) {
        System.out.println("You won!");
        }
        else System.out.println("You lost!");
    }
}
