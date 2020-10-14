package com.company.string;

public class Palindrom {
    public static boolean palindrom(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String palindrome = "abcba";
        System.out.println(palindrom(palindrome));
    }
}
