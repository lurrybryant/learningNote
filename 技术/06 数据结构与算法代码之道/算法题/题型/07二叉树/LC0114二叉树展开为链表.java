private TreeNode prev = null;
 2
 3public void flatten1(TreeNode root) {
 4    if (root == null)
 5        return;
 6    flatten1(root.right);
 7    flatten1(root.left);
 8    root.right = prev;
 9    root.left = null;
10    prev = root;
11}


public void flatten3(TreeNode root) {
 2    TreeNode cur = root;
 3    while (cur != null) {
 4        if (cur.left != null) {
 5            TreeNode last = cur.left;
 6            while (last.right != null)
 7                last = last.right;
 8            last.right = cur.right;
 9            cur.right = cur.left;
10            cur.left = null;
11        }
12        cur = cur.right;
13    }
14}