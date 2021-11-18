package com.company.functions;

public class Test {
    public static void main(String[] args) {
        MyInterface myInterface = () -> {
            return 1;
        };
        System.out.println(myInterface.get());
    }
}
