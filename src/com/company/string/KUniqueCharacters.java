package com.company.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class KUniqueCharacters {
    public static String find(String input, int k) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            set.add(c);
        }

        int max_Start = 0;
        int max_Length = 0;
        int curr_Start = 0;
        int curr_End = 0;
        int alphaCounts[] = new int[26];
        Arrays.fill(alphaCounts, 0);

        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';
            alphaCounts[index]++;
            curr_End++;
            while (!isValid(alphaCounts, k)) {
                alphaCounts[input.charAt(curr_Start) - 'a']--;
                curr_Start++;
            }
            if (curr_End - curr_Start > max_Length) {
                max_Start = curr_Start;
                max_Length = curr_End - curr_Start;
            }
        }

        return input.substring(max_Start, max_Start + max_Length);
    }

    public static boolean isValid(int alphaCounts[], int k) {
        int uniqueChars = 0;
        for (int i = 0; i < alphaCounts.length; i++) {
            if (alphaCounts[i] > 0)
                uniqueChars++;
        }

        if (uniqueChars > k)
            return false;

        return true;
    }

    public static String KUniqueCharacters(String str) {
        int k = (int) str.charAt(0);
        return find(str.substring(1), k);
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(KUniqueCharacters(s.nextLine()));
    }
}
