import java.io.IOException;

public class OperatorsDemo {


    public static void main(String[] arg) throws IOException {
        System.out.println("This is the performnace operators");
        System.out.println("Learning binary number representation");

        long i = 0b1010;
        System.out.println("Class is "+((Object)i).getClass()+ " Value is =>"+i);


        // bitwise operator
        // & and |
        int j = 8; // 1000
        int k = 10; // 1010

        int res = j&k; //   1000   (1&1 -> 1 and 1&0 -> 0 and 0&0 -> 0)
        System.out.println("Bitwise & output =>"+res);

        res = j|k; //   1010   (1&1 -> 1 and 1&0 -> 1 and 0&0 -> 0)
        System.out.println("Bitwise OR | output =>"+res);

        //Left shift  -> Increase the value
        res = j << 2;   // 1000 -> 100000  (Will add last two places and output will be  100000 -> 32)
        System.out.println("Bitwise Right Shift operator =>"+res);

        //Right shift  -> Decrease the value
        res = j >> 2;   // 1000 -> 10 ( Will remove last two places and output will be  10 -> 2)
        System.out.println("Bitwise Right Shift operator =>"+res);
    }
}
