package com.company.arrays;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] value : list) {
            for (int valInt : value) {
                result.add(valInt);
            }
        }
        return result;
    }
}
