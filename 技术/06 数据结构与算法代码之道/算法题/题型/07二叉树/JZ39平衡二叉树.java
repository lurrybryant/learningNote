// JZ39 平衡二叉树
// 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
// 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
// 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        int[] depth = new int[1];
        depth[0] = 0;
        return IsBalanced_Solution(root, depth);
    }
    public boolean IsBalanced_Solution(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (IsBalanced_Solution(root.left, left) && IsBalanced_Solution(root.right, right) ){
            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1) {
                depth[0] = diff > -1? left[0] + 1: right[0] + 1;
                return true;
            }
        }
        return false;
    }
}