package datastructure;

import java.util.Arrays;


/*
This comes with O(n2) complexity -> Quarditric complexity-> Degrade drastically once value increases.
It's an unStable sort
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] intArray = GeneralClass.getIntArray();
        System.out.println(Arrays.toString(intArray));

        for(int i = intArray.length; i > 0 ; i--){
            for(int j=0; j < i-1 ; j++){
                if(intArray[j] > intArray[j+1]){
                    int tmp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = tmp;
                }
            }
        }
        System.out.println("Sorted Array using bubble sort in ASC =>"+Arrays.toString(intArray));
    }
}
