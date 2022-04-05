
JZ59 按之字形顺序打印二叉树
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
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        if (pRoot == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        ArrayList<Integer> array = null;
        deque.addFirst(pRoot);
        int oddLevel = 1;
        while (!deque.isEmpty()) {
            array = new ArrayList<Integer>();
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                if (oddLevel == 1) {
                    TreeNode tn = deque.removeFirst();
                    array.add(tn.val);
                    if (tn.left != null)
                        deque.addLast(tn.left);
                    if (tn.right != null)
                        deque.addLast(tn.right);
                } else {
                    TreeNode tn = deque.removeLast();
                    array.add(tn.val);
                    if (tn.right != null) {
                        deque.addFirst(tn.right);
                    }
                    if (tn.left != null) {
                        deque.addFirst(tn.left);
                    }
                }
            }
            result.add(array);
            oddLevel = -oddLevel;
        }
        return result;
    }

}