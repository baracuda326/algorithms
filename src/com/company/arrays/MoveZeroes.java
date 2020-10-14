package com.company.arrays;

public class MoveZeroes {
    private static void moveZeroes(int[] nums) {
        int countMoved = 0, currentIndex = 0, index = 0;
        while (true) {
            index = indexOfZero(nums, countMoved, 0, currentIndex);
            if (index == -1) break;
            int buf = nums[index];
            countMoved++;
            currentIndex = index;
            for (int j = index; j < nums.length - countMoved; j++) {
                nums[j] = nums[j + 1];
            }
            nums[nums.length - countMoved] = buf;
        }
    }

    private static int indexOfZero(int[] nums, int countMoved, int number, int currentIndex) {
        for (int i = currentIndex; i < nums.length - countMoved; i++) {
            if (number == nums[i]) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] moveArray = {0, 0, 1};
        moveZeroes(moveArray);
    }
}
