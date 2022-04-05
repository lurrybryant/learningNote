

// 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
import java.util.ArrayList;
/**
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
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();  
    private ArrayList<Integer> list = new ArrayList<Integer>();  
  
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {  
        if (root == null)  
            return listAll;  
        list.add(root.val);  
        target -= root.val;  
        if (target == 0 && root.left == null && root.right == null)  
            listAll.add(new ArrayList<Integer>(list));  
        /* 
         * if (root.left != null) { FindPath(root.left, target); 
         * list.remove(list.size() - 1); } if (root.right != null) { 
         * FindPath(root.right, target); list.remove(list.size() - 1); } 
         */  
        // 继续遍历左右结点  
        FindPath(root.left, target);  
        FindPath(root.right, target);  
        // 在返回父节点之前，在路径上删除该结点  
        list.remove(list.size() - 1); 

        return listAll;  
    }  
}