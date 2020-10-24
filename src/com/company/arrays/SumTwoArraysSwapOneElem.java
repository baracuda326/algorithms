package com.company.arrays;

/**
 * Given two list return true if you can swap one number
 * from each list such that after the swapping the lists sum is equal
 */
public class SumTwoArraysSwapOneElem {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3, 4};
        System.out.println(checkArrays(a, 1, b, 2));
        System.out.println(checkArrays2(a, 1, b, 2));
    }

    private static boolean checkArrays(int[] a, int n, int[] b, int m) {
        if (a.length - 1 < n || b.length < m) throw new IllegalArgumentException();
        int sum1 = getSum(a);
        int sum2 = getSum(b);
        swapInPosition(a, n, b, m);
        return getSum(a) == sum1 || getSum(b) == sum2;
    }

    private static boolean checkArrays2(int[] a, int n, int[] b, int m) {
        if (a.length - 1 < n || b.length < m) throw new IllegalArgumentException();
        int sum1 = getSum(a);
        int sum2 = getSum(b);
        int buf1 = getNumberToIndex(a, n);
        int buf2 = getNumberToIndex(b, m);
        return (sum1 - buf1 + buf2) == sum1 || (sum2 - buf2 + buf1) == sum2;
    }

    private static int getNumberToIndex(int[] array, int n) {
        return array[n];
    }

    private static void swapInPosition(int[] a, int n, int[] b, int m) {
        int buf1;
        int buf2;
        buf1 = a[n];
        buf2 = b[m];
        a[n] = buf2;
        b[m] = buf1;
    }

    private static int getSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}
