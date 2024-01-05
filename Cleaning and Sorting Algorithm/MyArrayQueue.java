/*a queue class that uses a one-dimensional array */

public class MyArrayQueue 
{
   // data members
   int front;          // one counterclockwise from first element
   int rear;           // position of rear element of queue
   Object [] queue;    // element array

   // constructors
   /** create a queue with the given initial capacity */
   public MyArrayQueue(int initialCapacity){
      if (initialCapacity < 1)
         throw new IllegalArgumentException
               ("initialCapacity must be >= 1");
      queue = new Object [initialCapacity + 1];
      // default front = rear = 0
   }

   /** create a queue with initial capacity 5 */
   public MyArrayQueue(){// use default capacity of 5
      this(5);
   }

   // methods
   /** @return true if queue is empty */
   public boolean isEmpty(){
      return front == rear;
   }


   /** @return front element of queue
     * @return null if queue is empty */
   public Object getFrontElement(){
      if (isEmpty())
         return null;
      else
         return queue[(front + 1) % queue.length];
   }

   /** @return rear element of queue
     * @return null if the queue is empty */
   public Object getRearElement(){
      if (isEmpty())
         return null;
      else
         return queue[rear];
   }

   /** insert theElement at the rear of the queue */
   public void enqueue(Object theElement)	
   {
      
      if(( front % queue.length ) == ( rear + 1) % queue.length ){ //if it is  the same number then the function can go on
         int counter = 0;
         Object movingQueue[] = new Object[queue.length * 2]; //new duplicate array, using Object since the original array is also Object
         
         
         for ( int i = 0; i < queue.length - 1; i++ ){ //looping through the array elements

            movingQueue[counter] = queue[(front + 1) % queue.length]; //get elements from queue array and move it to the new array
            front = (front + 1) % queue.length; // change the int front so it can give the new front element next time
            counter = counter + 1; 
            
         }
         
         queue = movingQueue; //changing the array
         front = 0;
         counter = counter + 1;
         movingQueue[counter] = theElement; // putting in the element 
         rear = counter; // change the int rear to whatever the number of the counter is
         
      }
      
      else{
       
         rear = (rear + 1) % queue.length; // change the int rear so it can give the new rear element
         queue[rear] = theElement; // putting in the element
      }
	   
   }

   /** remove an element from the front of the queue
     * @return removed element */
   public Object dequeue()
   {

      if (isEmpty()){ //if the array empty then it can not be dequeued
         System.out.println("Unable to dequeue");
         return null;
 
       } else { // but if it is not empty that it will be dequeued
 
         Object removeObject = queue[(front + 1) % queue.length]; // grab the object that is going tobe remove
         queue[front] = null; // take out/ invalidate that element
         front = (front + 1) % queue.length; // change the int front so it can give the new front element next time
 
         return removeObject; // return the removed object
       }

   }
   
   /** test program */
   public static void main(String [] args)
   {  
      MyArrayQueue q = new MyArrayQueue(3);
      // add a few elements
      q.enqueue("element1");	//q.put(new Integer(1));
      q.enqueue("element2");	//q.put(new Integer(2));
      q.enqueue("element3");	//q.put(new Integer(3));
      q.enqueue("element4");	//q.put(new Integer(4));

      // remove and add to test wraparound array doubling
      q.dequeue();
      q.dequeue();
      q.enqueue("element5");	//q.put(new Integer(5));
      q.enqueue("element6");	//q.put(new Integer(6));
      q.enqueue("element7");	//q.put(new Integer(7));
      q.enqueue("element8");	//q.put(new Integer(8));
      q.enqueue("element9");	//q.put(new Integer(9));
      q.enqueue("element10");	//q.put(new Integer(10));
      q.enqueue("element11");	//q.put(new Integer(11));
      q.enqueue("element12");	//q.put(new Integer(12));

      // delete all elements
      while (!q.isEmpty()){
         System.out.println("Rear element   : " + q.getRearElement());
    	   System.out.println("Front element  : " + q.getFrontElement());
    	   System.out.println("Removed element: " + q.dequeue() + "\n");
      }

	  if (q.isEmpty()) System.out.println("empty queue");      
   }  
}
