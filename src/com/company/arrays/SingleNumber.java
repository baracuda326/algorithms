package com.company.arrays;

public class SingleNumber {
    private static int singleNumber(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (!isPresent(array, array[i], i)) {
                return array[i];
            }
        }
        return res;
    }

    static boolean isPresent(int[] nums, int number, int i) {
        for (int j = 0; j < nums.length; j++) {
            if (number == nums[j] && i != j) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] array = {2, 2, 1};
        singleNumber(array);
    }
}
