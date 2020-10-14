package com.company.arrays;

public class ReverseArrayCharsRecursive {
    private static void reverseArrayCharsRecursive(char[] c) {
        int lower = 0;
        int hight = c.length - 1;
        helperRecursive(c, lower, hight);
    }

    private static void helperRecursive(char[] c, int lower, int hight) {
        int i = lower;
        int j = hight;
        if (i < hight) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            helperRecursive(c, lower + 1, hight - 1);
        }
    }

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseArrayCharsRecursive(chars);
        System.out.println(chars);
    }
}
