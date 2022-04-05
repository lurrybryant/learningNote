// 连续子数组最大和
public int FindGreatestSumOfSubArray(int[] array) {
    if (array == null || array.length == 0) {
        return 0;
    }
    int maxSum = array[0];
    int currentSum = array[0];
    for (int i = 1; i < array.length; i++) {
        if (currentSum <= 0) {
            currentSum = array[i];
        } else {
            currentSum += array[i];
        }
        if (currentSum > maxSum) {
            maxSum = currentSum;
        }
    }
    return maxSum;
}



public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array == null) {
            return false;
        }
        int len = array.length;
        int i = 0;
        int j = array[0].length - 1;
        while (i < len && 0 <= j) {
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}


