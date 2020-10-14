package com.company.arrays;

import java.util.Arrays;

public class Inverter {
    public static void inverter(int[] array) {
        for (int k = 0; k < array.length / 2; k++) {
            int tmp = array[k];
            array[k] = array[array.length - 1 - k];
            array[array.length - 1 - k] = tmp;
        }
    }

    public static void inverterDecrement(int[] array) {
        int k = array.length % 2 == 0 ? array.length / 2 : array.length / 2 + 1;
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            int tmp = array[i];
            array[i] = array[k];
            array[k++] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 12, 5, 4, 6, 8, 7};
        System.out.println(array);
        inverter(array);
        System.out.println(Arrays.toString(array));
        inverterDecrement(array);
        System.out.println(Arrays.toString(array));
    }
}
