package com.company.arrays;

import java.util.Arrays;

//Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
//
//        Note that elements beyond the length of the original array are not written.
//
//        Do the above modifications to the input array in place, do not return anything from your function.
//
//
//
//        Example 1:
//
//        Input: [1,0,2,3,0,4,5,0]
//        Output: null
//        Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
//        Example 2:
//
//        Input: [1,2,3]
//        Output: null
//        Explanation: After calling your function, the input array is modified to: [1,2,3]
public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int[]buf = new int[arr.length];
        for(int i = 0, j = 0; i < arr.length && j < buf.length;i++){
            if(arr[i] != 0){
                buf[j] = arr[i];
                ++j;
            }else{
                j += 2;
            }
        }
        for(int i = 0; i < buf.length; i++){
            arr[i] = buf[i];
        }
    }
    public static void main(String[] args) {
    int[]arr = {1,0,2,3,0,4,5,0};
    duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
