package com.company.arrays;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] arr : array) {
            for (Integer element : arr) {
                list.add(element);
            }
        }
        return list;
    }
}
