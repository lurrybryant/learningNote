// 数字在升序数组中出现的次数

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null) {
            return 0;
        }
        int leftIndex = getFirst(array, 0, array.length - 1, k);
        int rightIndex = getLast(array, 0, array.length - 1, k);
        if (leftIndex > -1 && rightIndex > -1) {
            return rightIndex - leftIndex + 1;
        }
        return 0;
    }
    public int getFirst(int[] array, int start, int end, int k) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] == k) {
                if (start == mid || array[mid - 1] != k) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public int getLast(int[] array, int start, int end, int k) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] == k) {
                if (end == mid || array[mid + 1] != k) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}