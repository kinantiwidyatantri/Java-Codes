public class DiningPhilosophers {

    public static void main(String[] args) throws Exception {
        
        final int problemSize=5;
        Fork leftFork;
        Fork rightFork;
        
        Philosopher[] philosophers = new Philosopher[problemSize];
        Fork[] forks = new Fork[problemSize];

        for (int i = 0; i < problemSize; i++) {
            forks[i] = new Fork();
        }

        // make philosopher 1 pick up the right fork first then the left fork, this is the only part that have been modified
        philosophers[0] = new Philosopher(forks[0], forks[problemSize-1], 1);
        for (int i = 1; i < problemSize; i++) {
            leftFork = forks[i-1];
            rightFork = forks[i];

            philosophers[i] = new Philosopher(leftFork, rightFork, i+1);
        }

        for (int i = 0; i < problemSize; i++) {
            //leftFork = forks[i];
            //rightFork = forks[(i + 1) % problemSize];

            //philosophers[i] = new Philosopher(leftFork, rightFork, i+1);
            
            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }
}
