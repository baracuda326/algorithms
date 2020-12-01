package com.company.twoqcache;

public class TestCache {
    public static void main(String[] args) {
        ITwoQ<String, Integer> cache = new TwoQCache(10);
        cache.put("one",1);
        cache.put("two",2);
        cache.put("three",3);
        cache.put("four",4);
        cache.put("five",5);
        cache.put("six",6);
        cache.put("seven",7);
        cache.put("eighth",8);
        cache.put("nine",9);
        cache.put("ten",10);
        cache.put("eleven",11);
        cache.put("twelve",12);
        cache.put("thirteen",13);
        cache.put("fourteen",14);
        cache.put("fifteen",15);
        cache.put("sixteen",16);
        cache.put("seventeen",17);
        cache.put("eighteen",18);
        cache.put("nineteen",19);
        cache.put("twenty",20);
        System.out.println(cache.toString());
        System.out.println(cache.getMapHotSnapshot());
    }
}
