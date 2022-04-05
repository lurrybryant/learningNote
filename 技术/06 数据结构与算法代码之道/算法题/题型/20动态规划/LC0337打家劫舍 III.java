public int rob(TreeNode root) {
 2    int[] num = dfs(root);
 3    return Math.max(num[0], num[1]);
 4}
 5
 6private int[] dfs(TreeNode x) {
 7    if (x == null)
 8        return new int[2];
 9    int[] left = dfs(x.left);
10    int[] right = dfs(x.right);
11    int[] res = new int[2];
12    res[0] = left[1] + right[1] + x.val;
13    res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
14    return res;
15}