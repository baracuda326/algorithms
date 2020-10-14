package com.company.sort;

public class QuickSort {
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            //recursively sort elements 2 arrays
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;
    }

    public static void quickSort2(int[] arr, int begin, int end) {
        if (begin < end) {
            int l = begin + 1;
            int r = end;
            while (l < r) {
                if (arr[l] > arr[begin] && arr[r] < arr[begin]) {
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    l++;
                    r--;
                }
                l = l < begin ? l + 1 : l;
                r = r > begin ? r - 1 : r;
            }
            int temp = arr[l - 1];
            arr[l - 1] = arr[begin];
            arr[begin] = temp;
            quickSort(arr, begin, l - 1);
            quickSort(arr, l + 1, end);
        }
    }
}
