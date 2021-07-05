package threads;

public class Consumer implements Runnable {
    ThreadReourceExample th;
    public Consumer(ThreadReourceExample th) {
        this.th = th;
    }
    @Override
    public void run() {
        System.out.println("In Consumer");
        int counter=0;
        while (th.totalValue >= counter) {
           System.out.println("In Consumer Class Outcome is =>" + th.getValues());
            counter++;

            System.out.println("totalValue =>"+th.totalValue+ "counter=>"+counter);
        }

    }
}
