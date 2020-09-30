package com.company.arrays;

//Given an array A of integers, return true if and only if it is a valid mountain array.
//
//        Recall that A is a mountain array if and only if:
//
//        A.length >= 3
//        There exists some i with 0 < i < A.length - 1 such that:
//        A[0] < A[1] < ... A[i-1] < A[i]
//        A[i] > A[i+1] > ... > A[A.length - 1]
public class ValidMountainArray {
    public static boolean validMountainArray(int[] A) {
        int pointerLeft = 0;
        int pointerRight = A.length - 1;
        int current = 0;
        int currentRight = A.length - 1;
        if (A.length <= 2) return false;
        while (current < currentRight) {
            if (A[current] < A[++pointerLeft]) {
                current++;
            } else {
                if (A[currentRight] >= A[--pointerRight]) {
                    return false;
                } else {
                    currentRight--;
                }
            }
        }
        return current != 0 && currentRight != A.length - 1 && current == currentRight;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2};
        System.out.println(validMountainArray(A));
    }
}
