package com.company.thread;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        byte[] bytes = transform(arr);
        System.out.println(Arrays.toString(bytes));
    }

    private static byte[] transform(int[] arr) {
        byte[] buf = new byte[arr.length];
        String[] bufStr = new String[arr.length];
        StringBuilder str  = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            int in = Byte.toUnsignedInt((byte) arr[i]);

            str.append(String.format("%6s", Integer.toBinaryString(in)).replaceAll(" ", "0"));

            bufStr[i] = String.format("%6s", Integer.toBinaryString(in)).replaceAll(" ", "0");

            buf[i] = Byte.parseByte(Integer.toBinaryString(arr[i]));
        }
        System.out.println(str);
        System.out.println(Arrays.toString(bufStr));
        return buf;
    }
}