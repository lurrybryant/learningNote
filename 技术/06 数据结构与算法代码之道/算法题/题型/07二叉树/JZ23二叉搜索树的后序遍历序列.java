
// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
public class Solution {
public boolean VerifySquenceOfBST(int[] sequence) {  
        if (sequence == null || sequence.length == 0)  
            return false;  
        // 调用函数，java没有指针，要用下标模拟指针，新建函数判断  
        return IsTreeBST(sequence, 0, sequence.length - 1);  
    }  
  
    private boolean IsTreeBST(int[] sequence, int start, int end) {  
        // index是指示找到第一个大于左子树的结点  
        int index = start;  
        if (start + 1 >= end) {
            return true;
        }
        for (; index < end; index++)  
            if (sequence[index] > sequence[end])  
                break;  
        // 若右子树有小于跟结点的值，返回false  
        for (int i = index; i < end; i++)  
            if (sequence[i] < sequence[end])  
                return false;  
        return IsTreeBST(sequence, start, index - 1) && IsTreeBST(sequence, index, end - 1);  
    }  
}


public class Solution {
 public boolean VerifySquenceOfBST(int[] sequence) {  
        if (sequence == null || sequence.length == 0)  
            return false;  
        int len = sequence.length;  
        while (--len > 0) {  
            int i = 0;  
            while (sequence[i] < sequence[len])  
                i++;  
            while (sequence[i] > sequence[len])  
                i++;  
            if (i != len)  
                return false;  
  
        }  
        return true;  
    } 
}