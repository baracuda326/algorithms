package com.company.arrays;

/**
 * Given two list return true if you can swap one number
 * from each list such that after the swapping the lists sum is equal
 */
public class SumTwoArraysSwapOneElem {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3, 4};
        System.out.println(checkArrays(a, 1, b, 1));
        System.out.println(checkArrays2(a, 1, b, 1));
        System.out.println(checkArrays3(a, 1, b, 1));
    }

    private static boolean checkArrays(int[] a, int n, int[] b, int m) {
        if (a.length - 1 < n || b.length < m) throw new IllegalArgumentException();
        swapInPosition(a, n, b, m);
        return getSum(a) == getSum(b);
    }

    private static boolean checkArrays2(int[] a, int n, int[] b, int m) {
        if (a.length - 1 < n || b.length < m) throw new IllegalArgumentException();
        return (getSum(a) - a[n] + b[m]) == (getSum(b) - b[m] + a[n]);
    }

    private static boolean checkArrays3(int[] a, int n, int[] b, int m) {
        if (a.length - 1 < n || b.length < m) throw new IllegalArgumentException();
        return (getSum(a) - getSum(b)) / 2 == a[n] - b[m];
    }


    private static void swapInPosition(int[] a, int n, int[] b, int m) {
        int buf1 = a[n];
        int buf2 = b[m];
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
