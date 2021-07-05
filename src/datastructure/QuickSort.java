package datastructure;

import java.util.Arrays;

/**
 * This comes with O(n log n base 2) complexity -> Logarithmic complexity but in worst case it perform O(n2)
 It's an UnStable sort
 This sort os based on divide and conquer concepts. It also heavily based on recursion mechanism. We can use iterative mechanism as well.
 This sort is based on choosing pivot (A random element) and putting lesser value at left side and higher value at right side.
 There are some optimisations added during the data dependency .
 This Sort basically overcome the burden of element value comparison for insertion, shell or bubble sort.
 This sort not use the extra space like Merge sort and provide an easy solution

 Limitations-:
 As slow as bubble sort in the worst case!
 Iterative implementation isn’t easy
 There are faster algorithms for some sets of data types
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] intArray = GeneralClass.getIntArray();

    /*
    Implementation logic to perform Quick sort
        1. Choose indices 0 as pivot element and perform value comparison to find the right index for pivot
        2. Put the pivot at right place after performing the partitioning algo. Now we have two set Left and right divided by pivot
        3. Not perform same operation recursively. Here each element will get chance to be a pivot once.
        4. At the end we will receive the sorted array

       Note -> Partitioning will done using value shifting and holding current value from both left and right side.
               We have to make sure that left and right indices should not cross each other.
   */
        System.out.println("Unsorted array is => "+ Arrays.toString(intArray));
        quickSort(intArray, 0, intArray.length);
        System.out.println("Finally sorted array is => "+ Arrays.toString(intArray));
    }

    //TODO Need to perform the operation using iterative method
     public static void quickSort(int[] input, int start, int end){
        //Returning as pivot has has gone to the leaf level and divide happen till last element
         if(end - start < 2) {
             return;
         }
         //Will get the pivot index for that particular element which going to be fix for entire sorted order and divide on
         // Left and Right partitions
         int pivotIndex = partition(input, start, end);

         quickSort(input, start, pivotIndex);
         quickSort(input, pivotIndex+1, end);
     }

     public static int partition(int[] input, int start, int end){
         //This is using first element as pivot
         int pivot = input[start];
         int i = start;
         int j = end;

         while (i < j){

             // Please note that end always have +1 index value as we have choosen array length as end value
             //Empty loop from Right to Left
             while (i<j && input[--j] >= pivot);

             //Now shifting the value to the left where loops terminates and i and j don't have clashes
             if(i < j)
                 input[i] = input[j];

             //Empty loop from Left to Right
             // Also as pivot always be the first element so the comparison should be start after incrementing it by one
             while (i<j && input[++i] <= pivot);
             if(i < j)
                 input[j] = input[i];
         }

        // So at the end value of j become the pivot insertion indices
         input[j] = pivot;
         return j;
     }
}
