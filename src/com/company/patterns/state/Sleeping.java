package com.company.patterns.state;

public class Sleeping implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("Sleep");
    }
}
