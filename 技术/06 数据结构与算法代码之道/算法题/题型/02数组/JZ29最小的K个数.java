
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


public int findKthLargest(int[] nums, int k) {
 2    final PriorityQueue<Integer> queue = new PriorityQueue<>();
 3    for (int val : nums) {
 4        queue.add(val);//加入堆中
 5        //如果堆中元素大于k，则把堆顶元素给移除
 6        if (queue.size() > k)
 7            queue.poll();
 8    }
 9    return queue.peek();//返回堆顶元素
10}


public int findKthLargest(int[] nums, int k) {
 2    k = nums.length - k;//注意这里的k已经变了
 3    int lo = 0, hi = nums.length - 1;
 4    while (lo <= hi) {
 5        int i = lo;
 6        //这里把数组以A[lo]的大小分为两部分，
 7        //一部分是小于A[lo]的，一部分是大于A[lo]的
 8        // [lo,i]<A[lo]，[i+1,j)>=A[lo]
 9        for (int j = lo + 1; j <= hi; j++)
10            if (nums[j] < nums[lo])
11                swap(nums, j, ++i);
12        swap(nums, lo, i);
13        if (k == i)
14            return nums[i];
15        else if (k < i)
16            hi = i - 1;
17        else
18            lo = i + 1;
19    }
20    return -1;
21}
22
23//交换两个元素的值
24private void swap(int[] nums, int i, int j) {
25    if (i != j) {
26        nums[i] ^= nums[j];
27        nums[j] ^= nums[i];
28        nums[i] ^= nums[j];
29    }
30}
