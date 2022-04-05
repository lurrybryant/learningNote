public boolean isValidBST(TreeNode root) {
 2    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
 3}
 4
 5public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
 6    if (root == null)
 7        return true;
 8    //每个节点如果超过这个范围，直接返回false
 9    if (root.val >= maxVal || root.val <= minVal)
10        return false;
11    //这里再分别以左右两个子节点分别判断，
12    //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
13    //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
14    return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
15}
