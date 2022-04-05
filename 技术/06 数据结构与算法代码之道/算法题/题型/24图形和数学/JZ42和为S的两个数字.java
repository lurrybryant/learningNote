// JZ42 和为S的两个数字
// 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
// 如果有多对数字的和等于S，返回两个数的乘积最小的，如果无法找出这样的数字，返回一个空数组即可。

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return ret;
        }
        int smallIndex = 0;
        int bigIndex = array.length - 1;
        int sumSelf = array[smallIndex] + array[bigIndex];
        while (sumSelf != sum ) {
            if (sumSelf < sum) {
                smallIndex++;
            } else {
                bigIndex--;
            }
            if (smallIndex == bigIndex) {
                break;
            }
            sumSelf = array[smallIndex] + array[bigIndex];
        }
        if (sumSelf == sum) {
            ret.add(array[smallIndex]);
            ret.add(array[bigIndex]);
        }
        return ret;
    }
}