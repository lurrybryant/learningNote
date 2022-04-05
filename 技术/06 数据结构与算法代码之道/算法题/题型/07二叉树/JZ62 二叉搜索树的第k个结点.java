










// JZ62 二叉搜索树的第k个结点
// 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。

import java.util.*;/*
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
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (pRoot != null || !stack.isEmpty()) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                if (--k == 0) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }


}











