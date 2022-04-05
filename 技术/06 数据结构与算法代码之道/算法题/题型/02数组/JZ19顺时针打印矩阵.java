// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();  
        if (array.length == 0)  
            return result;  
        int n = array.length;
        int m = array[0].length;  
        if (m == 0)  
            return result;  
        // 此种方法关键点--求圈数  
        int layers = (Math.min(n, m) - 1) / 2 + 1;  
        // 要打印的圈数  
        for (int i = 0; i < layers; i++) {  
            // 打印每圈  
            for (int k = i; k < m - i; k++)  
                result.add(array[i][k]);// 左至右  
            for (int j = i + 1; j < n - i; j++)  
                result.add(array[j][m - i - 1]);// 右上至右下  
            // 注意k,j开始的下标  
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--)  
                result.add(array[n - i - 1][k]);// 右至左  
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--)  
                result.add(array[j][i]);// 左下至左上  
        }  
        return result;  
    }
}

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int row = matrix.length;
        int colum = matrix[0].length;
        int start = 0;
        while (row > 2 * start && colum > 2 * start) {
            list.addAll(print(matrix, row, colum, start));
            start++;
        }
       return list;
    }
    public ArrayList<Integer> print(int [][] matrix, int row, int colum, int start) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = start; i < colum - start; i++) {
            list.add(matrix[start][i]);
        }
        for (int i =start + 1; i < row - start; i++) {
            list.add(matrix[i][colum - start-1]);
        }
        if (start < row - 1 - start) {
        for (int i = colum - start - 2; i > start - 1; i--) {
            list.add(matrix[row - start-1][i]);
        }}
        if (start < colum -1 - start) {
        for (int i = row - start - 2; i > start; i--) {
            list.add(matrix[i][start]);
        }}
        return list;
    }
}
