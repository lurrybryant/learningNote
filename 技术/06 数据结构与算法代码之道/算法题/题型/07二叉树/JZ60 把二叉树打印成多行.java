
// JZ60 把二叉树打印成多行
// 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
// 例如：
// 给定的二叉树是{1,2,3,#,#,4,5}

import java.util.*;


/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    if (pRoot == null) {
        return arr;
    }
        
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(pRoot.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            arr.add(array);
            int q = queue.size();
            array = new ArrayList<Integer>();     

            for (int i = 0; i < q; i++) {
                
                TreeNode tn = queue.poll();
                if (tn.left != null) {
                    array.add(tn.left.val); 
                    queue.offer(tn.left);
                }
                 if (tn.right != null) {
                    array.add(tn.right.val); 
                    queue.offer(tn.right);
                }
                   
            }
        }
        return arr;
    }
    
}