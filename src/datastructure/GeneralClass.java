package datastructure;

public class GeneralClass {
    public static int[] getIntArray(){
        int[] intArray = {23,-12,89,11,-23,55,1,100, 23, 11, 22};
        return intArray;
    }

    public static String[] getStringArray(){
        String[] strArray = {"dkp","DHP","ABC","Zebra","Lion","DEER","OX","CAT"};
        return strArray;
    }

    public static void swap(int[] intArray, int firstIndex, int secondIndex){
        if(firstIndex == secondIndex){
            return;
        }
        int tmp = intArray[firstIndex];
        intArray[firstIndex] = intArray[secondIndex];
        intArray[secondIndex] = tmp;
    }
}
