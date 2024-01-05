public class GameRoute {
    public static CardDieInterface getGame(String ans){
        if (ans.equalsIgnoreCase("c")) {
            CardDieInterface cardGame = new CardGame();
            return cardGame;
        }

        else if (ans.equalsIgnoreCase("d")) {
            CardDieInterface dieGame = new DieGame();
            return dieGame;
        }

        return null;
    } 
}
