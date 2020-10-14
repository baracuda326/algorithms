package com.company.arrays;

public class ReverseArray {
    public static void reverseArr(int[] array) {
        int index = array.length / 2 - 1;
        while (index >= 0) {
            int tmp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = tmp;
            index--;
        }
    }

    public static void reverseArrayRecursive(int[] arr, int low, int hight) {
        int i = low;
        int j = hight;
        if (i < hight) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            reverseArrayRecursive(arr, low + 1, hight - 1);
        }
    }

    public static void reverseArrayIterative(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            high--;
            low++;
        }
    }

    public static void main(String[] args) {

    }
}
