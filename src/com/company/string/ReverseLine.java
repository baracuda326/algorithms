package com.company.string;

public class ReverseLine {
    public static String reverseLine(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    public static String reverseLineBuilder(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(reverseLine(str));
        String str2 = "abcdef";
        System.out.println(reverseLineBuilder(str2));
    }
}
