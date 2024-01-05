import java.io.*;

public class Game {
  public static void main(String[] args) throws Exception {
    // Ask whether to play a card game or a die game
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //the print out in the terminal
    System.out.print("Card (c) or Die (d) game? ");
    String ans = br.readLine();
    
    CardDieInterface game = GameRoute.getGame(ans);

    if(game == null){
      System.out.println("Input not understood");
    }
    else{
      try{
        game.initialiseGame();
        game.mainGame();
        game.declareGameWinner();
      }
      catch(Exception e){
        System.out.println("Error : " + e);
      }
    }
  }   
}

