package datastructure;


import java.util.Arrays;

/*
This comes with O(n2) complexity -> Quarditric complexity-> Degrade drastically once value increases.
It's an Stable sort
 */
public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("Performing the insertion sort.");
        int[] intArray  = GeneralClass.getIntArray();
        System.out.println("Received Value is =>"+ Arrays.toString(intArray));

        //Performing the insertion sort
        //Concept -> Mark lest most element as sorted and start comparing values from right one. In case more then one value present at
        //Left side then compare the current value with all of them and perform the right shift accordingly.
        //Here we generally do the shifting not the swapping. Because of the unnecessary shifting it's produce more steps and increase the complexity
        //{13,33,9,2,22,100,123,1,5}
        for(int i =1; i < intArray.length ; i++){
            int element = intArray[i];
            int j;
            for(j=i; j > 0 && intArray[j-1] > element ; j--){
                intArray[j] = intArray[j-1];
            }
            intArray[j] = element;
        }
        System.out.println("Insertion sort output =>"+Arrays.toString(intArray));


        //Insertion Sort Using Recursion
        int[] intArray1  = GeneralClass.getIntArray();
        System.out.println("Sorting using recursion"+Arrays.toString(intArray1));

        recursiveInsertionSort(intArray1, intArray1.length);

        System.out.println("Sorted using recursion"+Arrays.toString(intArray1));
    }

    public static void recursiveInsertionSort(int[] input, int end){
        if(end < 1){
            return;
        }

        int i = end-1;
        recursiveInsertionSort(input, i);
        int element = input[i];
        int j;
        for(j = i; j > 0 && input[j-1] > element ;  j--){
            input[j] = input[j-1];
        }
        input[j] = element;
    }
}

