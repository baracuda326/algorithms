package com.company.arrays;

import java.util.Arrays;

//Input: nums = [12,345,2,6,7896]
//        Output: 2
//        Explanation:
//        12 contains 2 digits (even number of digits).
//        345 contains 3 digits (odd number of digits).
//        2 contains 1 digit (odd number of digits).
//        6 contains 1 digit (odd number of digits).
//        7896 contains 4 digits (even number of digits).
//        Therefore only 12 and 7896 contain an even number of digits.
//Input: nums = [555,901,482,1771]
//        Output: 1
//        Explanation:
//        Only 1771 contains an even number of digits.
public class FindNumbersWithEvenNumberofDigits {
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(String.valueOf(nums[i]).length() % 2 == 0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {555,901,482,1771};

        System.out.println(findNumbers(nums));
    }
}
