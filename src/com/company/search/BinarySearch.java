package com.company.search;

public class BinarySearch {
    public static int binarySearch(int[] arr, int n) {
        int l = 0, r = arr.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (n > arr[mid]) {
                l = mid - 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int l, int r, int n) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (arr[mid] == n) {
            return mid;
        }
        if (n > arr[mid]) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
        return binarySearchRecursive(arr, l, r, n);
    }
}
