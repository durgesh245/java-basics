package datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
This comes with O(n2) complexity -> Quarditric complexity-> Degrade drastically once value increases.
It's an Stable sort
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] intArray = GeneralClass.getIntArray();
        for(int i = intArray.length-1; i > 0; i--)
        {
            int largestIndex = 0;
            for(int j = 0; j <= i; j++){
                if(intArray[largestIndex] < intArray[j]){
                    largestIndex = j;
                }
            }

            GeneralClass.swap(intArray, largestIndex, i);
        }

        System.out.println("Values Sorted by Selection sort is =>"+ Arrays.toString(intArray));

        HashMap<Object, Object> dd = new HashMap<>();
        dd.put("1",1);
        dd.put(1,2);
        System.out.println(dd);  //
        fun(dd);
        dd.put("3",2);
        fun(dd);
        dd.put("2",2);
        System.out.println(dd);  //
        dd.put(null, null);
        dd.put(null, 2);
        System.out.println("value->"+dd.get("1"));    //
        System.out.println(dd);    //

    }

    static void fun(Map mm){
        mm.put("5",2);
    }
}
