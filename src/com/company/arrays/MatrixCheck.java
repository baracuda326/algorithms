package com.company.arrays;

public class MatrixCheck {
//    public boolean mono(boolean[][] data) {
//        boolean result = false;
//        for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
//          if (data[0][0] != data[i][i] || data[i][j] != data[j][i]) {
//              result = true;
//              break;
//          }
//        }
//        return result;
//    }

    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0, k = data.length - 1; j < data.length; j++, k--) {
                if ((i == j) || (k == j)) {
                    if ((data[i][j] == data[i][k]) || (data[i][j] != data[k][j])) {
                        continue;
                    } else {
                        result = false;
                    }
                }
            }
        }
        return result;
    }
}
