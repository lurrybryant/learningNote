public List<Integer> rightSideView(TreeNode root) {
 2    List<Integer> res = new ArrayList<>();
 3    dfs(root, res, 0);
 4    return res;
 5}
 6
 7public void dfs(TreeNode curr, List<Integer> res, int level) {
 8    //递归的终止条件判断
 9    if (curr == null) {
10        return;
11    }
12    //level表示的是第几层，因为是先遍历右子树，所以每一层最先遍历
13    //的结点值就是我们所需要的，当下面语句成立的时候，就表示当前节
14    //点值所在的那一行是最先遍历的，所以要把他加入到集合res中
15    if (level == res.size()) {
16        res.add(curr.val);
17    }
18    //先遍历右子树，在遍历左子树
19    dfs(curr.right, res, level + 1);
20    dfs(curr.left, res, level + 1);
21}



public List<Integer> rightSideView(TreeNode root) {
 2    List<Integer> res = new ArrayList<>();
 3    //终止条件判断
 4    if (root == null)
 5        return res;
 6    //创建队列
 7    Queue<TreeNode> queue = new LinkedList();
 8    queue.offer(root);
 9    while (!queue.isEmpty()) {
10        //每层的数量
11        int count = queue.size();
12        while (count-- > 0) {
13            //当前节点出队
14            TreeNode cur = queue.poll();
15            //因为每层是从左往右依次入队的，所以每层的
16            //最后一个就是我们所需要的
17            if (count == 0)
18                res.add(cur.val);
19            //左子树如果不为空，左子树入队，右子树如果不为空
20            //右子树入队
21            if (cur.left != null)
22                queue.offer(cur.left);
23            if (cur.right != null)
24                queue.offer(cur.right);
25        }
26    }
27    return res;
28}


