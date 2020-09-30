package com.company.arrays;

import java.util.Arrays;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//        Note:
//
//        The number of elements initialized in nums1 and nums2 are m and n respectively.
//        You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
//        Example:
//
//        Input:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        Output: [1,2,2,3,5,6]
public class MergeSortedArray {
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0, j = m; i < nums2.length; i++, j++) {
            nums1[j] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (index1 >= 0 && index2 >= 0) {
                nums1[i] = nums1[index1] < nums2[index2] ? nums2[index2--] : nums1[index1--];
            } else if (index1 >= 0 && index2 < 0) {
                nums1[i] = nums1[index1--];
            } else if (index1 < 0 && index2 >= 0) {
                nums1[i] = nums2[index2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        int m = 1;
        int n = 0;
        merge(nums1, m, nums2, n);
    }
}
