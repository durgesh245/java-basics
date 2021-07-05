package threads;

public class ThreadReourceExample {
    private String str;
    private double num;
    public boolean isNewValue = false;
    public int totalValue = 0;

//    public  double getNum() {
//        return num;
//    }
//
//    public void setNum(double num) {
//        this.num = num;
//    }
//
//    public  String getStr() {
//        return str;
//    }
//
//    public  void setStr(String str) {
//        this.str = str;
//    }

    public synchronized void setValues(String str, double num){
        System.out.println("Producer Set Values Str=>" + str + "  Num =>" + num);
        while (isNewValue){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.str = str;
        this.num = num;
        isNewValue = true;
        totalValue++;
        notify();
    }

    public synchronized String getValues(){
        while (!isNewValue){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String returnVal = "Str =>"+str+ ", Num=>"+num;
        System.out.println("Consumer get values ="+returnVal);
        isNewValue= false;
        notify();
        return returnVal;
    }
}
