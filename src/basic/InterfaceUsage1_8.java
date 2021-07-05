package basic;

interface A {
    default void F1(){
        System.out.println("This interface default");
    }

    static void F2(){
        System.out.println("This interface static");
    }
}
public class InterfaceUsage1_8 implements A{

    public static void main(String[] args) {

        A a =new InterfaceUsage1_8();
        a.F1();
        A.F2();

        String[] strInput = {"bcdef","dbaqc", "abcde", "omadd", "bbbbb"};
        int[] input;
        for(String str : strInput){
            for(char ch: str.toCharArray()){
                int cc = ch;
                System.out.println("Character Printing=>"+ch+ " and integer Value =>"+cc);
            }
        }
    }
}
