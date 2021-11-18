package com.company.singleton;

public class Test {
    public static void main(String[] args) {
        ThreadSafeSingleton safeSingleton = ThreadSafeSingleton.getInstance();
        safeSingleton.add("Test");
        int i=0;
        for (String value : safeSingleton.getCopyListVariant()) {
            safeSingleton.add("Test" + ++i);
            System.out.println(safeSingleton.getCopyListVariant());
            safeSingleton.remove("Test");
        }
        safeSingleton.getCopyListVariant().add("test3");
        System.out.println(safeSingleton.getCopyListVariant());
    }
}
