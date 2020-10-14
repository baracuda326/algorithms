package com.company.arrays;

import java.util.ArrayList;
import java.util.List;

public class IsHappyNumber {
    private static boolean isHappy(int number) {
        List<Integer> list = new ArrayList<>();
        int result;
        int buf = recursion(number);
        result = recursion(buf);
        while (true) {
            if (result != 1) {
                result = recursion(result);
                if (list.contains(result)) return false;
                list.add(result);
            } else {
                return true;
            }
        }
    }

    private static int recursion(int number) {
        String a = String.valueOf(number);
        char[] i = a.toCharArray();
        int res = 0;
        for (int index = 0; index < i.length; index++) {
            int buf = Character.getNumericValue(i[index]);
            res += buf * buf;
        }
        return res;
    }

    public static void main(String[] args) {
        int number = 3;
        isHappy(number);
    }
}
