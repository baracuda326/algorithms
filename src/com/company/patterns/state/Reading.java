package com.company.patterns.state;

public class Reading implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("reading book");
    }
}
