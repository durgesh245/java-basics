package datastructure;

import java.util.Arrays;

/**
 * 1. It generally perform on length and position of the values.
 * 2. Most of the time Radix sort implemented using Counting Sort.
 * 3. For Radix sort data should be stable so to do that we have to perform additional steps to make it satble.
 * 4. Complexity is  O(n) -> liner but definitely are some overhead so it will perform a bit slower.
 * 5. It's a good alternative for Counting sort if we have bunch of data with defined width and large ranges.
 * 6.  For numeric data we generally use the total digits 0-9 (10) as radix.
 * 7. Radix sort can be implemented for String and variable length data set. We are only going with numeric and fixed width.
 */
public class RadixSort {
    public static void main(String[] args) {
        System.out.println("Radix sort started with the help of counting Sort");
        int[] input = {2424,5533,5745,1222,0000,1232,3333,1967,2231,9999,2312, 89, 786};

        String[] strInput = {"bcdef","dbaqc", "abcde", "omadd", "bbbbb"};

        getRedix(input, 4, 10);
        System.out.println("Response is in sorted array is =>"+ Arrays.toString(input));

        //Sorting for string based elements


    }

    public static void getRedix(int[] input, int  width, int radix){
        for(int i = 0; i < width; i++){
            radixSingleSort(input, i, radix);
        }
    }

    //Created this method to sort the string based input arrays.
    public static void getRadixForString(){

    }

    public static void radixSingleSort(int[] input, int position, int radix){
        int numLen = input.length;
        int[] countArray = new int[radix];
        for(int value : input){
            countArray[getDigit(value, position, radix)]++ ;
        }

        //Now going to perform the operation related to stable sorting
        // Adjust the count array
        for(int i = 1; i < radix ; i++){
            countArray[i] += countArray[i - 1];
        }

        //Sorting with main logic from right to left
        int[] num = new int[numLen];
        for(int tmpIndex=numLen-1; tmpIndex >= 0; tmpIndex--){
            num[--countArray[getDigit(input[tmpIndex], position, radix)]] = input[tmpIndex];
        }

        for(int i =0; i < numLen; i++ ){
            input[i] = num[i];
        }
    }

    //This method providing the value at that particular position.
    public static int getDigit(int value, int position, int radix){
        return value / (int) Math.pow(radix, position) % radix;
    }
}
