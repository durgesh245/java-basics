package threads;

import java.util.Arrays;
import java.util.List;

class GenericUtil{
    public static void executeDataSet(Object cls){
        List<String> strList = Arrays.asList("data1", "data2", "data3", "data4", "data5");
        for(String str : strList){
            if(cls != null)
                System.out.println("executeDataSet Values is =>"+str+" With Class => "+cls.getClass());
            else
                System.out.println("executeDataSet Values is =>"+str);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


//Using Thread Class
class ThreadA extends Thread{
    @Override
    public void run() {
        System.out.println("Run method started in Thread A");
        GenericUtil.executeDataSet(this);
    }
}
//Using Thread Class
class ThreadB extends Thread{
    @Override
    public void run() {
        System.out.println("Run method started in Thread B");
        GenericUtil.executeDataSet(this);
    }
}




//Using Runnable Interface
class ThreadC implements Runnable{
    @Override
    public void run() {
        System.out.println("Run method started in Thread C");
        GenericUtil.executeDataSet(this);
    }
}

//Using Runnable Interface
class ThreadD implements Runnable{
    @Override
    public void run() {
        System.out.println("Run method started in Thread D");
        GenericUtil.executeDataSet(this);
    }
}


public class BasicThreadExecution {
    public static void main(String[] args) {
        System.out.println("Thread getting started. Going to use the Thread class ");
        ThreadA thA = new ThreadA();
        ThreadB thB = new ThreadB();
        thA.start();
        try { thA.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        thB.start();

        System.out.println("Check if thread is live A=>"+ thA.isAlive()+ "  B=>"+thB.isAlive());
        try {
            thA.join();
            thB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Check if thread is live after join  A=>"+ thA.isAlive()+ "  B=>"+thB.isAlive());
        System.out.println("Thread example getting ended. Going to Start implementation using Runnable Interface ");


        Thread t1 = new Thread(new ThreadC(), "Thread-C");
        Thread t2 = new Thread(new ThreadD(), "Thread-D");
        Thread t3 = new Thread(() -> {
                                    System.out.println("This is an annonymous data set.");
                                    GenericUtil.executeDataSet(null);
                                  }
                                , "AnnonymousThread"); //Initiating a thread using Runnable Lambda expresion
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Bye");
    }
}
