package streams;

import javax.sound.midi.Soundbank;
import java.util.*;

 interface A {
     void test();
}

public class LambdaWithCollections{
    public static void main(String[] args) {
        List<Integer> valueList = new ArrayList<>();
        Set<String> valueSet = new HashSet<>();
        Map<String, Integer> valueMap = new HashMap<>();

        //Filling the collection data

        for(int i=0; i< 10; i++){
            String str = "name"+i;
            valueList.add(i);
            valueSet.add(str);
            valueMap.put(str, i);
        }

        Integer count = 0 ;
        //Performing the foreach for every collection
        valueList.forEach((i) -> {
            System.out.println("List values are =>"+i);
        });

        System.out.println("\nPrinting the Set Values \n");
        valueSet.forEach((i) -> {
            System.out.println("Set values are =>"+i);
        });

        System.out.println("\n Printing the structure for Map \n");

        valueMap.forEach((i,j) -> {
            System.out.println("\n Printing the key "+i+"=>"+j+" \n");
        });

        System.out.println("\n Printing the List Using method reference \n");
        //Printing values using Method reference
        valueList.forEach(System.out::println);


        //Annonymous class example
       final int j =0;
        A ls = new A(){
            int k=0;
            public void test(){
                k++;
                System.out.println("This is an annonymous method"+j+" This is K =>"+k);
            }
        };
        ls.test();

        ls = () -> System.out.println("this is annonymous with lambda expression ");
        ls.test();
    }
}
