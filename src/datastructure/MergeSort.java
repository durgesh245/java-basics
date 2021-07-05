package datastructure;

/*
This comes with O(n log n base 2) complexity -> Logarithmic complexity
It's an Stable sort
This sort os based on divide and conquer concepts. It also heavily based on recursion mechanism.
This sort is based on optimisation of dividing the collection uptil  the last element and then combining them in sorted order.
There are some optimisations added during the data dependency .
This Sort basically overcome the burden of element value comparison for insertion, shell or bubble sort.
This sort use the extra space as we have to use the temporary collection to put the values in sorted format

Limitations -:

1. Slower than non-comparison based algorithms
Merge sort is however based on the comparison model and as such can be slower than algorithms non-based on comparisons that can sort data in linear time. Of course, this depends on the input data, so we must be careful for the input.

2. Difficult to implement for beginners
Although I don’t think this can be the main reason why not to use merge sort some people say that it can be difficult to implement for beginners, especially the merge part of the algorithm.

3. Slower than insertion and bubble sort for nearly sorted input
Again it is very important to know the input data. Indeed if the input is nearly sorted the insertion sort or bubble sort can be faster. Note that in the best case insertion and bubble sort complexity is O(n), while merge sort’s best case is O(n*log(n)).

*/

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("Starting Merge sort ");
        int[] intArray = GeneralClass.getIntArray();
        System.out.println("Values without sorting are =>"+ Arrays.toString(intArray));
        /*             0                                  11 -> taking length as end value (always +1 for left array)
        //Values are {23,-12,89,11,-23,55,1,100, 23, 11, 22};  -> 11
           Mid values =>  0+10 / 2 = 5   Will treat mid value as start index for right array
           0                4(mid->5)      5                11
           {23,-12,89,11,-23}  -          {55,1,100, 23, 11, 22}
            0     1     2         4     5       7       8       11 (len)
           {23, -12} - {89, 11, -23} - {55, 1, 100} - {23, 11, 22}

           {23} - {-12} - {89} - {11, -23} - {55} - {1, 100} - {23} - {11, 22}
            0       1
           {23} - {-12} - {89} - {11} - {-23} - {55} - {1} {100} - {23} - {11} {22}
        */
        mergeSort(intArray, 0, intArray.length);

        System.out.println("Final Result is in sorted way =>"+Arrays.toString(intArray));
    }

    //Note-> End will be always the length not the index -> It means always +1 with the last index from the array
    public static void mergeSort(int[] input, int start, int end){
        if((end - start) < 2){
            return;
        }
        int mid = (start+end) /  2;

        //For left array again partition
        mergeSort(input, start, mid);
        //For right array again partition
        mergeSort(input, mid, end);

        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end){

       // System.out.println("Starting merging the values are =>"+Arrays.toString(input) + " start =>"+start+ " Mid=>"+mid+ " End=>"+end);

        if(input[mid-1] <= input[mid] ){
            return;
        }

        int i = start;
        int j = mid;
        int tmpCounter= 0 ;
        int[] tmpArray =  new int[end - start];

        while (i < mid && j < end){
            tmpArray[tmpCounter++] = (input[i] <= input[j]) ? input[i++] : input[j++];
        }
        //There are some leftover in both left and right array, We will skip right (as it will contains the higher values) one but have to insert left one
/*
public static void arraycopy(Object source_arr, int sourcePos,
                            Object dest_arr, int destPos, int len)
Parameters :
source_arr : array to be copied from
sourcePos : starting position in source array from where to copy
dest_arr : array to be copied in
destPos : starting position in destination array, where to copy in
len : total no. of components to be copied.
 */

       // System.out.println("merging the values are =>"+Arrays.toString(input) + " start =>"+start+ " Mid=>"+mid+ " End=>"+end);
        System.arraycopy(input, i, input, start+tmpCounter, mid-i); // Bit Trickey
        System.arraycopy(tmpArray, 0, input, start, tmpCounter);
    }
}
