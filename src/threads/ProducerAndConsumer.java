package threads;


import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ProducerAndConsumer {
    public static void main(String[] args) {
        System.out.println("Producer and Consumer Example started");
        ThreadReourceExample th = new ThreadReourceExample();

        //Creating thread using runnable  classes
        Thread t1 = new Thread(new Producer(th), "Thread-Produce");
        Thread t2 = new Thread(new Consumer(th), "Thread-Consume");
        t1.start();
        t2.start();

        //Will to complete all the threads till here. Then complete the call.
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Example using Thread producer and consumer has end");
    }
}
