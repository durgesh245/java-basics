package datastructure;

/*
    1. It works on some assumptions eg. 1. value should be whole number. 2. Data length should not be huge
    2. It an unstable in nature but can achieve stability by using some extra steps.
    3. It work on the principle of number count of a particular values and don't do the internal comparison internally.
    4. It's simply  count the occurance  of values and place it in original collection using number count and it's indices
    5. Because of the assumptions it provide O(n) -> Liner complexity
    6. It's required extra space as we have to maintain value count separately.
    7. As stated, It works only on whole number so negative number and float numbers are not allowed.
 */

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        System.out.println("Starting the counting sort");
        int[] intArray = {53,325,22,677,2883, 3333, 11,25, 5,200, 20, 400, 200, 53, 22};
        System.out.println(Arrays.toString(intArray));

        //Starting the implementation
        //We will be assuming that caller have know the min and max value from the input array. If not, he should get those by performing
        // the other operations to get min and max values

        countingSort(intArray, 5, 3333);

        System.out.println("Values after sorting =>"+Arrays.toString(intArray));
    }

    public static void countingSort(int[] input, int min, int max){
        int[] tmpArray = new int[(max - min) + 1]; // creating array by saving some space
        for(int i = 0; i < input.length; i++){
            tmpArray[input[i] - min]++;
        }
        int j =0;
        for(int i = min; i <= max; i++){
            while (tmpArray[i-min] > 0){
                input[j++] = i;
                tmpArray[i-min]--;
            }
        }
    }
}
