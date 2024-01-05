import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> deleteStopwords(String NameOfFile, String Stopwords){
        File originalFile = new File(NameOfFile); //intializing file for the input
        File listOfStopwords = new File(Stopwords); //intializing file for the stop words

        /* I put all the necessay data into arraylist. It is the easiest way because we are being asked to return arraylist at the end. 
        Not only that arraylist is also re-sizeable, which is important thing in this coursework since we have to remove some elements */

        ArrayList<String> wordsFromOriginalFile = new ArrayList<String>(); // intializing arraylist for the input file
        ArrayList<String> wordsFromStopwordFile = new ArrayList<String>(); // intializing arraylist for the stop word file
            
        try{ //using the try-catch in case the are any errors
            Scanner inputFile = new Scanner(originalFile); // scanner for input file
            Scanner inputStopwords = new Scanner(listOfStopwords); //scanner for the stop word file
            
            while ( inputFile.hasNext() ){ // loop for reading the input file
                /*removing all the punctuation, numbers and changing it to lowercase, since I think they are unnnecessary and it would prevent the program 
                from actually removing some of the stop words */
                
                String inputWords = inputFile.next();
                String modified = inputWords.toLowerCase().replaceAll("'re","").replaceAll("'s","").replaceAll("n't","").replaceAll("[^a-zA-Z0-9]","").replaceAll("( )+", " ");
               
                wordsFromOriginalFile.add(modified); //adding the modified words to the arraylist
                
            }
            
    
            while ( inputStopwords.hasNext() ){ // loop for reading the stopword file
                wordsFromStopwordFile.add(inputStopwords.next()); // adding the stopword to the arraylist
            }

            //close the scanner
            inputFile.close();
            inputStopwords.close();

            
            /*I used the following method because it is simple to implement. Since I do believe that it is beneficial to make the code as simple as possible*/
            wordsFromOriginalFile.removeAll(wordsFromStopwordFile); //remove the stopwords

        }

        /* I only used 'exception' since it is more general and can identified different type of errors */
        catch( Exception e ){ // catch the program if there is something wrong 
            System.out.println("Something went wrong.");
        }

        return wordsFromOriginalFile; //return arraylist of the non stop words
        
    }
    
    public static void main(String[] args) { // main method
        /* I create two diffrent arraylist for the two different test, in case it gets mixed up. I know it takes more memory space, but if there are some
        mistakes that I made it is easier to find them */
        ArrayList<String> modifiedFile1 = deleteStopwords("input.txt", "stopwords.txt"); //intialized arraylist 
        ArrayList<String> modifiedFile2 = deleteStopwords("input.txt", "stopwords.txt"); //intialized arraylist

        SortingAlgorithm.completeInsertionSort(modifiedFile1); //call method for measuring the performance of insertion sort algorithm
       
        SortingAlgorithm.completeMergeSort(modifiedFile2); //call method for measuring the performance of merge sort algorithm
               
       
    }

}
