import java.util.ArrayList;

public class SortingAlgorithm {

    static int move; // initialize the int move to measure the performance
    static int move1; // initialize the int move to measure the performance
    static int swaps; // initialize the int swap to measure the performance

    public static void insertionSort(ArrayList<String> listOfWords){ // insertion sort algorithm
		int n = listOfWords.size(); // intialize the size of the arraylist
		
		for ( int i = 1; i < n; i++ ){ // looping through the arraylist
			String item = listOfWords.get(i); // get the element of the i index 
			int j = i - 1; // initialize the j to get the element before i
			
			while ( j >= 0 && listOfWords.get(j).compareTo(item) > 0 ){ /*loop the fucntion as long as j is bigger than 0 
                and the element(j) is not the same as element(i) */
                move1 = move1 + 1; // use to calculate the move for measuring the performance
                swaps = swaps + 1;
				listOfWords.set( j + 1, listOfWords.get(j) ); // change the position
				j = j - 1; 
			}
			
			listOfWords.set( j + 1, item ); // change the position
            move1 = move1 + 1; // use to calculate the move for measuring the performance
        }   
		} 
    
    public static void insertionSortPerformance(ArrayList<String> listOfWords, int numberOfWords) { // use to measure the performance
        move1 = 0; // counter fro the move
        swaps = 0; //counter for the swap
        //create new arraylist so we can measure the performance for certain amount of words
        ArrayList<String> partialArray = new ArrayList<String>(listOfWords.subList(0, numberOfWords)); 

        long startTime = System.nanoTime(); //start the time

        insertionSort(partialArray); // call the method

        long estimatedTime = System.nanoTime() - startTime; // measure the time taken

        //give the output
        System.out.println("\n" + "Word count: " + numberOfWords);
        System.out.println("\n" + "Estimated time to count "+ numberOfWords + " words: " +  estimatedTime + " nanoseconds");
        System.out.println("\n" + "Number of moves: " + move1);
        System.out.println("\n" + "Number of swaps: " + swaps);
        System.out.println("\n" + partialArray);
        System.out.println("\n" + "---------------------------------------------------------------------------------------");
    }

    public static void completeInsertionSort(ArrayList<String> listOfWords){ 
        if ( listOfWords.size() < 100){ // measure the performance for the the first  less 100 words
            System.out.println("\n" + "------------------------------ Insertion Sort Algorithm ------------------------------");
            insertionSortPerformance( listOfWords, listOfWords.size());
        }

        else if ( listOfWords.size() >= 100 && listOfWords.size() < 200 ){ // measure the performance for the the first 100 words
            System.out.println("\n" + "------------------------------ Insertion Sort Algorithm ------------------------------");
            insertionSortPerformance( listOfWords, 100 );
            insertionSortPerformance( listOfWords, listOfWords.size());
        }

        else if ( listOfWords.size() >= 200 && listOfWords.size() < 500 ){// measure the performance for the the first 200 words
            System.out.println("\n" + "------------------------------ Insertion Sort Algorithm ------------------------------");
            insertionSortPerformance( listOfWords, 100 );
            insertionSortPerformance( listOfWords, 200 );
            insertionSortPerformance( listOfWords, listOfWords.size());
        }
        
        else if ( listOfWords.size() >= 500){// measure the performance for the the first 500 words and above
            System.out.println("\n" + "------------------------------ Insertion Sort Algorithm ------------------------------");
            insertionSortPerformance( listOfWords, 100 );
            insertionSortPerformance( listOfWords, 200 );
            insertionSortPerformance( listOfWords, 500 );
            insertionSortPerformance( listOfWords, listOfWords.size());
        }
    }
        
        public static void mergeSort(ArrayList<String> listOfWords){ // first part of the merge sort algorithm, which is just dividing the arraylist
            int n = listOfWords.size(); //initialize the size of the arraylist
            move = move + 1; // counter for the move

            if( n < 2 ){ // return if the size of the arrylist is less than two
                return;
            }
            
            int middle = n / 2; // divide the array list into two part
            ArrayList<String> leftPart = new ArrayList<String>(); // intialize the arraylist for the left part since we need to divide it into two
            ArrayList<String> rightPart = new ArrayList<String>(); // intialize the arraylist for the right part since we need to divide it into two

            for (int i = 0; i < middle; i++) { // loop for the left part of the the arraylist
                move = move + 1; //counter for the move
                leftPart.add(listOfWords.get(i)); // add all the left part from listOfWords into a new leftPart arraylist

            }
            
            for (int i = middle; i < listOfWords.size(); i++) { // loop for the left part of the the arraylist
                move = move + 1; //counter for the move
                rightPart.add(listOfWords.get(i)); // add all the right part from listOfWords into a new rightPart arraylist
            }
            

            mergeSort(leftPart); //continue dividing the arraylist into a smaller one 
            mergeSort(rightPart); //continue dividing the arraylist into a smaller one
    
            merge(leftPart, rightPart, listOfWords); // merge the right and left part together
        
        } 

        public static void merge(ArrayList<String> firstPart, ArrayList<String> secondPart, ArrayList<String> listOfWord){ /*second part of the merge sort algorithm, 
            which merge the sorted sequence and swaps it around*/
            int x = 0; //initialize x to be used like an index to swap around the elements
            
            while (firstPart.size() != 0 && secondPart.size() != 0) { // loop will continue until the arraylist is empty
                move = move + 1; // counter for the move
                if (firstPart.get(0).compareTo(secondPart.get(0)) < 0) { /*if the first element on the left side is not equal to
                    the first part of the right side*/  
                    listOfWord.set(x++, firstPart.get(0)); // move the element of the left side into the next free position in the listOfWords arraylist
                    firstPart.remove(0); // then it will remove that element from the left side arraylsit
                }

                else{
                    listOfWord.set(x++, secondPart.get(0)); // move the element of the right side into the next free position in the listOfWords arraylist
                    secondPart.remove(0); // then it will remove that element from the right side arraylsit
                }
            }
            
            while (firstPart.size() != 0) { // while the the firstPart arraylist is not empty
                move = move + 1; // counter for the move
                listOfWord.set(x++, firstPart.get(0)); //move whatever remains to the listOfWords arraylist
                firstPart.remove(0); // then it will remove that element from the left side arraylsit
            }
            
            while (secondPart.size() != 0) { // while the the secondPart arraylist is not empty
                move = move + 1; // counter for the move
                listOfWord.set(x++, secondPart.get(0)); //move whatever remains to the listOfWords arraylist
                secondPart.remove(0); // then it will remove that element from the right side arraylsit
            }
        } // (Saxena, 2022)


        public static void mergeSortPerformance(ArrayList<String> listOfWords, int numberOfWords) {
            move = 0;// counter for the move
            //create new arraylist so we can measure the performance for certain amount of words
            ArrayList<String> partialArray = new ArrayList<String>(listOfWords.subList(0, numberOfWords));
    
            long startTime = System.nanoTime(); //start the time
    
            mergeSort(partialArray); // call the method
    
            long estimatedTime = System.nanoTime() - startTime; // measure the time taken
            
            //give the output
            System.out.println("\n" + "Word count: " + numberOfWords);
            System.out.println("\n" + "Estimated time to count "+ numberOfWords + " words: " +  estimatedTime + " nanoseconds");
            System.out.println("\n" + "Number of moves: " + move);
            System.out.println("\n" + partialArray);
            System.out.println("\n" + "---------------------------------------------------------------------------------------");
        }

        public static void completeMergeSort(ArrayList<String> listOfWords){
            if ( listOfWords.size() < 100){ // measure the performance for the the first  less 100 words
                System.out.println("\n" + "------------------------------ Merge Sort Algorithm ------------------------------");
                mergeSortPerformance( listOfWords, listOfWords.size());
            }

            else if ( listOfWords.size() >= 100 && listOfWords.size() < 200 ){ // measure the performance for the the first 100 words
                System.out.println("\n" + "------------------------------ Merge Sort Algorithm ------------------------------");
                mergeSortPerformance( listOfWords, 100 );
                mergeSortPerformance( listOfWords, listOfWords.size());
            }

            else if ( listOfWords.size() >= 200 && listOfWords.size() < 500 ){ // measure the performance for the the first 200 words
                System.out.println("\n" + "------------------------------ Merge Sort Algorithm ------------------------------");
                mergeSortPerformance( listOfWords, 100 );
                mergeSortPerformance( listOfWords, 200 );
                mergeSortPerformance( listOfWords, listOfWords.size());
            }
            
            else if ( listOfWords.size() >= 500){ // measure the performance for the the first 500 words and above
                System.out.println("\n" + "------------------------------ Merge Sort Algorithm ------------------------------");
                mergeSortPerformance( listOfWords, 100 );
                mergeSortPerformance( listOfWords, 200 );
                mergeSortPerformance( listOfWords, 500 );
                mergeSortPerformance( listOfWords, listOfWords.size());
            }
        }
}

