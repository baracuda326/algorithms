package com.company.twoqcache;

public class TestCache {
    public static void main(String[] args) {
        TwoQCache<String, Integer> cache = new TwoQCache(4);
        cache.put("one",1);
        cache.put("two",2);
        cache.put("three",3);
        cache.put("four",4);
        cache.put("five",5);
        cache.put("six",6);
        cache.put("seven",7);
        cache.put("eighth",8);
        cache.put("nine",9);
        System.out.println(cache.toString());
        System.out.println(cache.getMapHotSnapshot());
    }
}
