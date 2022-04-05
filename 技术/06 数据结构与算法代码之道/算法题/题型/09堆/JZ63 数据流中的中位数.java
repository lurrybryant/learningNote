// JZ63 数据流中的中位数
import java.util.*;

public class Solution {  
    int count = 0;  
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();  
    // 11是默认的初始容量  
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {  
        @Override  
        // PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器  
        public int compare(Integer o1, Integer o2) {  
            return o2.compareTo(o1);  
        }  
    });  
  
    public void Insert(Integer num) {  
        count++;  
        if ((count & 1) == 0) {// 判断偶数  
            if (!maxheap.isEmpty() && num < maxheap.peek()) {  
                maxheap.offer(num);  
                num = maxheap.poll();  
            }  
            minheap.offer(num);  
        } else {  
            if (!minheap.isEmpty() && num > minheap.peek()) {  
                minheap.offer(num);  
                num = minheap.poll();  
            }  
            maxheap.offer(num);  
        }  
    }  
  
    public Double GetMedian() {  
        if (count == 0)  
            throw new RuntimeException("非法");  
        double median = 0;  
        // 总数为奇数时，大顶堆堆顶就是中位数  
        if ((count & 1) == 1)  
            median = maxheap.peek();  
        else  
            // 注意2.0  
            median = (maxheap.peek() + minheap.peek()) / 2.0;  
        return median;  
  
    }  
}








