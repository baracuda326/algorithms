package com.company.patterns.creational.strategy.operations;

public class Divide  implements Operations{
    @Override
    public int execute(int a, int b) {
        return a / b;
    }
}
