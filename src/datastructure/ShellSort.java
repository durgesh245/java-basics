package datastructure;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
This comes with O(n2) complexity -> Quarditric complexity-> Degrade drastically once value increases.
It's an UnStable sort

//Concept -> It's an improved version of insertion sort by reducing the value shift using various algorithms.
            generally it's work on the principle of Gap during sorting to reduce the shifting and steps.
            At last it's perform the insertion sort where Mark lest most element as sorted and start comparing values from right one.
            In case more then one value present at Left side then compare the current value with all of them and perform the right
             shift accordingly.
        Note-: There is one popular method to get the gap interval is using Knuth algorithm where
        if collection length =k then   gap = (3^k-1)/2  so sequence is 1, 4, 13, 40, 121 etc.
 */
public class ShellSort {
    public static void main(String[] args) {
        System.out.println("Starting Shell sort ");

        //Preparing a long rang of integer values.
        int[] intArray = IntStream.range(0, 10000000).toArray();
        int[] intArray1 = GeneralClass.getIntArray();
        Arrays.copyOf(intArray, intArray.length+intArray1.length);
        for(int i = 0 ; i < intArray1.length; i++){
            intArray[i] = intArray1[i];
            intArray[intArray.length-intArray1.length-1+i] = intArray1[i];
        }
        System.out.println("Value Testing for random values is =>"+intArray[intArray.length-5]);

        //Staring implementation of Shell sort with short integer -:
        // {23,-12,89,11,-23,55,1,100, 23, 11};
        //Using the simple formula as Gap = ArrayOfLength/2


        for(int gap = intArray1.length/2;  gap > 0  ; gap/=2){
            for (int i = gap; i < intArray1.length ; i++){
                int element = intArray1[i];
                int j =i;
                while (j >= gap && intArray1[j - gap] > element){
                    intArray1[j] = intArray1[j-gap];
                    j -= gap;
                }
                intArray1[j] = element;
            }
        }

        System.out.println("Sorted array using shell sort is => "+Arrays.toString(intArray1));


        //Shell sort using knuth method
        for(int gap = (3^intArray1.length - 1)/2;  gap > 0  ; gap/=2){
            for (int i = gap; i < intArray1.length ; i++){
                int element = intArray1[i];
                int j =i;
                while (j >= gap && intArray1[j - gap] > element){
                    intArray1[j] = intArray1[j-gap];
                    j -= gap;
                }
                intArray1[j] = element;
            }
        }
        System.out.println("Sorted array using shell sort using knuth is => "+Arrays.toString(intArray1));
    }
}
