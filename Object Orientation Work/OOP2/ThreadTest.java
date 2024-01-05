import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        int Threads = 15; //the amount of threads use, this can be change into any value
        int Cards = 52; //the amount of card

        //remove the comment depends on which class is being tested, i know this could have been improve by passing it as an argument
        //CardDeck deck = new CardDeck();  // this one to test CardDeck.java
        ThreadSafeCardDeck deck = new ThreadSafeCardDeck(); //this one to test ThreasSafeCardDeck.java

        //initialised ExecutorService for the number of threads
        ExecutorService execute =  Executors.newFixedThreadPool(Threads);

        //loop through the threads, each thread will execute the dealCard() method
        for( int i = 0; i < Threads; i++){
            execute.execute(deck::dealCard);
            
        }

        execute.shutdown(); // shutdown the ExecutorService after looping through all the threads
        while(!execute.isTerminated()){ //wait for all the threads to complete their task,//
            Thread.sleep(500);  // return true if all task is completed and it will return false otherwise, which will make the loop continue running until the task is completed/
        }

        int leftoverCards = deck.cardList.size(); //numbers of card left in the deck after all threads have finished their task
        int sequenceNumber = deck.sequenceNumber; // number of card that have been dealt by the threads

        if(sequenceNumber >= Threads && leftoverCards == Cards - Threads){ // if statement that check whether the method is thread safe or not
            System.out.println("This method is thread-safe");
        } else {
            System.out.println("This method is not thread-safe");
        }
    }
}