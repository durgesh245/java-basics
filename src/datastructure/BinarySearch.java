package datastructure;

//Assumption is that all the items are sorted and should apply the algorithm required to
// fetch the data by molding the middle elements
public class BinarySearch {
    public static void main(String[] args) {
                    //  0   1   2   3   4   5   6    7     8
        int[] input = {-22, -1, 0, 22, 23 , 44, 99, 100, 102};

        int index = -1;
        //Binary search using iteration
        index = getIterativeBinarySearch(input , -23);
        System.out.println("Values position is => "+index);

        System.out.println(getIterativeBinarySearch(input , -22));
        System.out.println(getIterativeBinarySearch(input , 102));
        System.out.println(getIterativeBinarySearch(input , 109));
        System.out.println(getIterativeBinarySearch(input , 100));
        System.out.println(getIterativeBinarySearch(input , 0));


        //Binary search using recursion
        //index = getRecursiveBinarySearch(input , 99);


    }

    public static int getIterativeBinarySearch(int[] input , int val){
        int index = -1;
        int start = 0;
        int end = input.length ;
        while(start < end){
            int mid = (start+end) /2;
            if(input[mid] ==  val){
                index =  mid;
                break;
            }
            if(input[mid] < val){
              start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return index;
    }

    public static int getRecursiveBinarySearch(int[] input , int val){
        int index = -1;

        return index;
    }

    public static int getRecursiveValueIndex(int[] input, int start, int end){
        int index = -1;

        return index;
    }
}
