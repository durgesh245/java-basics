package threads;

public class Producer implements Runnable {
    ThreadReourceExample th;
    public Producer(ThreadReourceExample th) {
        this.th = th;
    }
    @Override
    public void run() {
        System.out.println("In Producer Class");
        for(int i=0; i < 10; i++) {
            String Str = String.valueOf(i);
            double num = Math.random();
            th.setValues(Str, num);
        }
    }
}
