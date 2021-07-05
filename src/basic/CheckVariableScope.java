package basic;

import datastructure.GeneralClass;

import java.util.Arrays;

public class CheckVariableScope {
    public static void main(String[] args) {
        int[] ints = GeneralClass.getIntArray();
        int cnt = 9;
        System.out.println("Before method calling values Array=>"+ Arrays.toString(ints)+ " cnt value=>"+cnt);
        changeTheValues(ints, cnt);
        System.out.println("After method calling values Array=>"+ Arrays.toString(ints)+ " cnt value=>"+cnt);
    }

    public static void changeTheValues(int[] arr, int cnt){
        arr[3] = 2764772;
        cnt++;
        System.out.println("In method after calling values Array=>"+ Arrays.toString(arr)+ " cnt value=>"+cnt);
    }
}
