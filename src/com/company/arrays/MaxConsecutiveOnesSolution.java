package com.company.arrays;

import java.util.HashMap;

public class MaxConsecutiveOnesSolution {
    //Given a binary array, find the maximum number of consecutive 1s in this array.

    /*
     *Input: [1,1,0,1,1,1]
     *Output: 3
     *Explanation: The first two digits or the last three digits are consecutive 1s.
     *The maximum number of consecutive 1s is 3.
     * Note:
     *The input array will only contain 0 and 1.
     *The length of input array is a positive integer and will not exceed 10,000
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int countMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0;
            } else {
                ++count;
                if (count >= countMax) {
                    countMax = count;
                }
            }
        }
        return countMax;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}