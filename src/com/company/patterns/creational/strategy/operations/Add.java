package com.company.patterns.creational.strategy.operations;

public class Add implements Operations{
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}
