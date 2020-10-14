package com.company.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagram = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String line : strs) {
            char[] chars = line.toCharArray();
            java.util.Arrays.sort(chars);
            String lineBuf = String.valueOf(chars);
            if (!map.containsKey(lineBuf)) {
                List<String> listBuf = new ArrayList<>();
                listBuf.add(line);
                map.put(lineBuf, listBuf);
            } else {
                map.get(lineBuf).add(line);

            }
        }
        for (List<String> k : map.values()) {
            ArrayList<String> list = new ArrayList<>();
            list.addAll(k);
            anagram.add(list);
        }
        return anagram;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
