package com.company.map;

//var m = Map.of(
//        "red", List.of("tomato", "radish", "pepper"),
//        "yellow", List.of("corn", "squash", "pumpkin"),
//        "green", List.of("cucumber", "broccoli", "lettuce"));
//        1.	Write an expression that prints all of the vegetable names to system output in alphabetical order.
//        2.	Write an expression that transforms m to a map mReverse that maps vegetable names to their color
//        (mReverse = { "tomato": "red", "cucumber": "green", ... })

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestMap {
    public static void main(String[] args) {
        var m = Map.of(
                "red", List.of("tomato", "radish", "pepper"),
                "yellow", List.of("corn", "squash", "pumpkin"),
                "green", List.of("cucumber", "broccoli", "lettuce"));
//        printVariantFirst(m);
//        printVariantSecond(m);
//        printVariantThird(m);
//        printVariantFourth(m);
//       Map<String,String> map = reverseMapVariantFirst(m);
        Map<String,String> map = reverseMapVariantSecond(m);
        System.out.println(map);
    }

    private static Map<String, String> reverseMapVariantSecond(Map<String, List<String>> m) {
        return m.entrySet()
                .stream()
                .flatMap(e -> e.getValue().stream().map(s -> new AbstractMap.SimpleEntry<>(s, e.getKey())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (l, r) -> l));
    }
    private static Map<String, String> reverseMapVariantThird(Map<String, List<String>> m) {
        return m.entrySet().stream()
                .collect(HashMap::new, (l,e)->e.getValue().forEach(v->l.put(v,e.getKey())), Map::putAll);
    }

    private static Map<String, String> reverseMapVariantFirst(Map<String, List<String>> m) {
        Map<String,String> map = new HashMap<>();
        for(Map.Entry<String,List<String>> entry : m.entrySet()){
            for (String value : entry.getValue()){
                map.put(value,entry.getKey());
            }
        }
        return map;
    }

    private static void printVariantThird(Map<String, List<String>> m) {
        m.entrySet().stream().map(Map.Entry::getValue)
                .flatMap(l -> l.stream()).sorted().collect(Collectors.toList()).forEach(System.out::println);
    }
    private static void printVariantFourth(Map<String, List<String>> m) {
        m.entrySet().stream().map(Map.Entry::getValue)
                .flatMap(l -> l.stream()).sorted().forEach(System.out::println);
    }

    private static void printVariantSecond(Map<String, List<String>> m) {
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,List<String>> value : m.entrySet()){
            list.addAll(value.getValue());
        }
        list.sort(String::compareTo);
        System.out.println(list);
    }

    private static void printVariantFirst(Map<String, List<String>> m) {
        Set<String> set = new TreeSet<>();
        for(Map.Entry<String,List<String>> value : m.entrySet()){
            set.addAll(value.getValue());
        }
        System.out.println(set);
    }
}
