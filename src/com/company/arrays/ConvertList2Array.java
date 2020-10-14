package com.company.arrays;

import java.util.List;

public class ConvertList2Array {

    public static int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int cellIndex = 0;
        int rowIndex = 0;
        for (Integer value : list) {
            array[rowIndex][cellIndex++] = value;
            if (cellIndex >= cells) {
                rowIndex++;
                cellIndex = 0;
            }
        }
        return array;
    }
}

