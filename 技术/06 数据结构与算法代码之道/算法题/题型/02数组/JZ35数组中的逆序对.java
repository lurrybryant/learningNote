
// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
// 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
public class Solution {
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {  
            return 0;  
        }  
        int[] copy = new int[array.length];  
        // for复制？？？可省  
        for (int i = 0; i < array.length; i++) {  
            copy[i] = array[i];  
        }  
        // 数值过大求余  
        int count = InversePairsCore(array, copy, 0, array.length - 1);  
        return count;  
    }  
  
    private int InversePairsCore(int[] array, int[] copy, int low, int high) {  
        if (low == high) {  
            return 0;  
        }  
        // mid属于前半部分最后一个数字  
        int mid = (low + high) >> 1;  
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;  
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;  
        int count = 0;  
        // i初始前半部分最后一个数字  
        int i = mid;  
        // j初始后半部分最后一个数字  
        int j = high;  
        // indexCopy记录copy数组的下标  
        int locCopy = high;  
        while (i >= low && j > mid) {  
            if (array[i] > array[j]) {  
                // j-mid~j的数都小于等于j的(排序)，j的数字小于i  
                count += j - mid;  
                copy[locCopy--] = array[i--];  
                if (count >= 1000000007)// 数值过大求余  
                    count %= 1000000007;  
            } else {  
                copy[locCopy--] = array[j--];  
            }  
        }  
        for (; i >= low; i--)  
  
        {  
            copy[locCopy--] = array[i];  
        }  
        // 剩余部分依次放入临时数组  
        for (; j > mid; j--) {  
            copy[locCopy--] = array[j];  
        }  
        for (int s = low; s <= high; s++) {  
            array[s] = copy[s];  
        }  
        return (leftCount + rightCount + count) % 1000000007;  
    
    }
}



public class Solution {
    int count = 0;
    public int InversePairs(int [] array) {
        if (array != null && array.length != 0) {
            int[] copy = new int[array.length];
            mergeCount(array, copy, 0, array.length - 1);
            return count;
        } else {
            return 0;
        }
    }

    public void mergeCount(int[] array, int[] copy, int start, int end) {
        if (start >= end) {
            return ;
        }
        int mid = (start + end) >> 1;
        mergeCount(array, copy, start, mid);
        mergeCount(array, copy, mid + 1, end);
        merge(array, copy, start, mid, end);
    }

    public void merge(int[] array, int[] copy, int start, int mid, int end) {
        int start2 = mid + 1;
        int index = start;
        int i = start;
        while (start <= mid && start2 <= end) {
            if (array[start] > array[start2]) {
                copy[index++] = array[start2++];
                count = (count + mid - start + 1) % 1000000007;
            } else {
                copy[index++] = array[start++];
            }
        }
        while (start <= mid) {
            copy[index++] = array[start++];
        }
        while (start2 <= end) {
            copy[index++] = array[start2++];
        }
        for (int k = i; k <= end; k++) {
            array[k] = copy[k];
        }
    }
}


