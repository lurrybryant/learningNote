// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
           public TreeNode reConstructBinaryTree(int[] pre, int[] in) {  
            TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);  
            return root;  
        }  
  
        // 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}  
        private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {  
  
            if (startPre > endPre || startIn > endIn)  
                return null;  
            TreeNode root = new TreeNode(pre[startPre]);  
  
            for (int i = startIn; i <= endIn; i++)  
                if (in[i] == pre[startPre]) {  
                    root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);  
                    root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);  
                 return root; 
                }  
            return null;
        }  
    
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0) {
            return null;
        }
        int j = 0;
        for (;j < in.length; j++) {
            if (in[j] == pre[0]) {
                break;
            };
        }
        TreeNode no = new TreeNode(pre[0]);
        int[] pre1 = new int[j];       
        int[] in1 = new int[j];      
        System.arraycopy(pre, 1, pre1, 0, j);
        System.arraycopy(in, 0, in1, 0, j);
        no.left = reConstructBinaryTree(pre1, in1);
        pre1 = new int[pre.length - j - 1];
        in1 = new int[pre1.length];
        System.arraycopy(pre, j + 1, pre1, 0, pre1.length);
        System.arraycopy(in, j + 1, in1, 0, in1.length);
        no.right = reConstructBinaryTree(pre1, in1);
        return no;
    }
}


// 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
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
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {  
        boolean result = false;  
        // 当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false  
        if (root2 != null && root1 != null) {  
            // 如果找到了对应Tree2的根节点的点  
            if (root1.val == root2.val) {  
                // 以这个根节点为为起点判断是否包含Tree2  
                result = doesTree1HaveTree2(root1, root2);  
            }  
            // 如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2  
            if (!result) {  
                result = HasSubtree(root1.left, root2);  
            }  
            // 如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2  
            if (!result) {  
                result = HasSubtree(root1.right, root2);  
            }  
        }  
        // 返回结果  
        return result;  
    }  
  
    public boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {  
        // 如果Tree2已经遍历完了都能对应的上，返回true  
        if (root2 == null) {  
            return true;  
        }  
        // 如果Tree2还没有遍历完，Tree1却遍历完了。返回false  
        if (root1 == null) {  
            return false;  
        }  
        // 如果其中有一个点没有对应上，返回false  
        if (root1.val != root2.val) {  
            return false;  
        }  
        // 如果根节点对应的上，那么就分别去子节点里面匹配  
        return doesTree1HaveTree2(root1.left, root2.left) &&   
                doesTree1HaveTree2(root1.right, root2.right);  
    }  
}


// 操作给定的二叉树，将其变换为源二叉树的镜像。
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
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right !=null) {
            Mirror(root.right);
        }
    }
}

// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
import java.util.*;
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }
}

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


// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

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
    TreeNode head = null;  
    TreeNode realHead = null;  
  
    public TreeNode Convert(TreeNode pRootOfTree) {  
        ConvertSub(pRootOfTree);  
        return realHead;  
    }  
  
    private void ConvertSub(TreeNode pRootOfTree) {  
        if (pRootOfTree == null)  
            return;  
        ConvertSub(pRootOfTree.left);  
        if (head == null) {  
            head = pRootOfTree;  
            realHead = pRootOfTree;  
        } else {  
            head.right = pRootOfTree;  
            pRootOfTree.left = head;  
            head = pRootOfTree;  
        }  
        ConvertSub(pRootOfTree.right);  
    }  
}








