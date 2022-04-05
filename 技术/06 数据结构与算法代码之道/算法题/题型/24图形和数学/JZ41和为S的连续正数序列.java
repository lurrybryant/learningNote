// 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
// JZ41 和为S的连续正数序列
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if (sum < 3) {
            return new ArrayList<ArrayList<Integer>>();
        }
        int big = 2;
        int small = 1;
        int sumSelf = 3;
        ArrayList<ArrayList<Integer>> arrAll = new ArrayList<ArrayList<Integer>>();
        
        
        while (big <= (sum +1) / 2) {
            if (sumSelf < sum) {
                big++;
                sumSelf += big;
            } else if (sumSelf > sum) {
                sumSelf -= small;
                small++;
            } else {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                for (int i = small; i <= big; i++) {
                    arr.add(i);
                }
                arrAll.add(arr);
                sumSelf -= small;
                small++;
                
            }
        }
        return arrAll;
    }
}
