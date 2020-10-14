package com.company;

public class Factorial {
    public static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    public static int factorialRecursive(int n) {
        return (n == 0) ? 1 : n * factorialRecursive(n - 1);
    }
}
