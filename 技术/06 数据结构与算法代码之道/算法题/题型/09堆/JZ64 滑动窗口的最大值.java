
// JZ64 滑动窗口的最大值
// 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
// 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
import java.util.*;

// 单调递减栈
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
         ArrayList<Integer> maxWindows = new ArrayList<>();  
        if (num == null || size == 0 || num.length == 0 || num.length < size)  
            return maxWindows;  
        Deque<Integer> dq = new LinkedList<>();  
        for (int i = 0; i < size; i++) {  
            while (!dq.isEmpty() && num[i] > num[dq.getLast()])  
                dq.removeLast();  
            dq.addLast(i);  
        }  
        //System.out.println(dq);  
        for (int i = size; i < num.length; i++) {  
            maxWindows.add(num[dq.getFirst()]);  
            while (!dq.isEmpty() && num[i] >= num[dq.getLast()])  
                dq.removeLast();  
  
            if (!dq.isEmpty() && dq.getFirst() <= i - size)  
                dq.removeFirst();  
            dq.addLast(i);  
           // System.out.println(i + "--" + dq);  
        }  
        maxWindows.add(num[dq.getFirst()]);  
        return maxWindows; 
    }
}

import java.util.*;
//思路：用一个大顶堆，保存当前滑动窗口中的数据。滑动窗口每次移动一格，就将前面一个数出堆，后面一个数入堆。
public class Solution {
    public PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((o1,o2)->o2-o1);//大顶堆
    public ArrayList<Integer> result = new ArrayList<Integer>();//保存结果
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num==null || num.length<=0 || size<=0 || size>num.length){
            return result;
        }
        int count=0;
        for(;count<size;count++){//初始化滑动窗口
            maxQueue.offer(num[count]);
        }
        while(count<num.length){//对每次操作，找到最大值（用优先队列的大顶堆），然后向后滑动（出堆一个，入堆一个）
            result.add(maxQueue.peek());
            maxQueue.remove(num[count-size]);
            maxQueue.add(num[count]);
            count++;
        }
        result.add(maxQueue.peek());//最后一次入堆后没保存结果，这里额外做一次即可

        return result;
    }
}

