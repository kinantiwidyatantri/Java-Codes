public interface CardDieInterface {
    //initialised the game
    public void initialiseGame() throws Exception;

    // Play the main game phase
    public void mainGame() throws Exception;

    // Now see if (s)he has won!
    public void declareGameWinner() throws Exception;
    
}
