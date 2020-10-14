package com.company.string;

public class LineContainsDigits {
    public static void main(String[] args) {
        String str = "123a2";
        String str2 = "12345";
        System.out.println(solution(str));
        System.out.println(solution(str2));
    }

    public static boolean solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
