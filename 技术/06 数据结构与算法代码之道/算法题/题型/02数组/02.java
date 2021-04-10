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

// 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public boolean Find(int target, int [][] array) {

     boolean exist = false;
     int yIndex = array[0].length - 1;
     int xIndex = 0, m = 0;
     while (xIndex < array.length && yIndex >= 0) {
         m = array[xIndex][yIndex];
         if (m == target) {
             exist = true;
             break;
         } else if (m > target) {
             yIndex--;
         } else {
             xIndex++;
         }
     }
     return exist;
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

// 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。
// NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return array[low];
    
    }
}

import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        return min(array, 0, array.length-1);
    }
    public int min(int[] array, int first, int last) {
        int mid = (first + last) / 2;
        int min = 0;
        if (first == last) {
            return min = array[first];
        } 
        if (array[mid] < array[last]) {
            min = min(array, first, mid);
        } else {
            min = min(array, mid + 1, last);
        }
        return min;
    }
}

// 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
// n<=39
public class Solution {
    public int Fibonacci(int n) {
        if (n <1) {
            return 0;
        }
        if (n == 1|| n == 2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int ret = 0;
        for (int i = 3; i <= n; i++) {
            ret = f1 + f2;
            f1 = f2;
            f2 = ret;
        }
        return ret;
    }
}

// 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
public class Solution {
    public int JumpFloor(int target) {
        if (target < 1) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        int ret = 0;
        for (int i = 3; i <= target; i++) {
            ret = f1 + f2;
            f1 = f2;
            f2 = ret;
        }
        return ret;
    }
}

// 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class Solution {
    public int JumpFloorII(int target) {
        return  1<<--target;
    }
}



// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class Solution {
    public void reOrderArray(int [] array) {
        int[] newArr = new int[array.length];  
        //newArr的下标计数器  
        int j = 0;  
        for (int i = 0; i < array.length; i++)  
            if ((array[i] & 1) == 1) {  
                newArr[j] = array[i];  
                j++;  
            }  
        for (int i = 0; i < array.length; i++)  
            if ((array[i] & 1) == 0) {  
                newArr[j] = array[i];  
                j++;  
            }  
        for (int i = 0; i < array.length; i++)  
            array[i] = newArr[i];  
    }
}

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


// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

public int MoreThanHalfNum_Solution(int [] array) {
    if (array.length <= 0)  
        return 0;  
    int res = array[0];  
    int times = 1;  
    for (int i = 1; i < array.length; i++) {  
        if (times == 0) {  
            res = array[i];  
            times = 1;  
        } else if (array[i] == res)  
            times++;  
        else  
            times--;  
    }  
  
    times = 0;  
    for (int i = 0; i < array.length; i++)  
        if (res == array[i])  
            times++;  
    if (times * 2 > array.length)  
        return res;  
    else  
        return 0;  
    }


// 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return arr;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partion(input, start, end);
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
                index = partion(input, start, end);
            } else {
                end = index - 1;
                index = partion(input, start, end);
            }
        }
        
        for (int i = 0; i <= index; i++) {
            arr.add(input[i]);
        }
        return arr;
    }
    public int partion(int[] input, int start, int end) {
        int small = start - 1;
        for (int index = start; index < end; ++index) {
            if (input[index] < input[end]) {
                small++;
                if (small != index) {
                    int temp = input[index];
                    input[index] = input[small];
                    input[small] = temp;
                }
            }
        }
        small++;
        int temp = input[end];
        input[end] = input[small];
        input[small] = temp;
        return small;
    }

// topK 问题
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MaxHeapTest {

    public static void main(String[] args) {
        int[] num = {4,5,1,6,2,7,3,8};

        List<Integer> result = GetLeastNumbers_Solution(num,4);

        result.stream().forEach(System.out::println);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        //最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}


// 快速排序
// def partition(L, left, right):
//     """
//     将L[left:right]进行一次快速排序的partition，返回分割点
//    :param L: 数据List
//     :param left: 排序起始位置
//    :param right: 排序终止位置
//    :return: 分割点
//     """
//     if left < right:
//         print left
//         key = L[left]
//         low = left
//         high = right
//         while low < high:
//             while low < high and L[high] >= key:
//                 high = high - 1
//             L[low] = L[high]
//             while low < high and L[low] <= key:
//                 low = low + 1
//             L[high] = L[low]
//         L[low] = key
//     return low


// def topK(L, K):
//     """
//     求L中的前K个最小值
//     :param L: 数据List
//     :param K: 最小值的数目
//     """
//     if len(L) < K:
//         pass
//     low = 0
//     high = len(L) - 1
//     j = partition(L, low, high)
//     while j != K: # 划分位置不是K则继续处理
//       if K > j: #k在分划点后面部分
//          low = j + 1
//         else:
//             high = j           # K在分划点前面部分
//       j = partition(L, low, high)


// 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323

 public String PrintMinNumber(int [] numbers) {
        int len = numbers.length;
        if (numbers == null || len == 0) {
            return "";
        }
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(str, new Comparator<String>(){
            //@Override
            public int compare(String str1, String str2) {
                String c1 = str1 + str2;
                String c2 = str2 + str1;
                return c1.compareTo(c2);
            }
        });
        for (int i = 0 ; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();

    }

// 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。












