package com.company;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int n1 = 0;
        int n2 = 1;
        int res = n1 + n2;
        while (n > 2) {
            n1 = n2;
            n2 = res;
            res = n1 + n2;
            n--;
        }
        return res;
    }

    public static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
