public TreeNode lowestCommonAncestor(TreeNode cur, TreeNode p, TreeNode q) {
 2    if (cur == null || cur == p || cur == q)
 3        return cur;
 4    TreeNode left = lowestCommonAncestor(cur.left, p, q);
 5    TreeNode right = lowestCommonAncestor(cur.right, p, q);
 6    //如果left为空，说明这两个节点在cur结点的右子树上，我们只需要返回右子树查找的结果即可
 7    if (left == null)
 8        return right;
 9    //同上
10    if (right == null)
11        return left;
12    //如果left和right都不为空，说明这两个节点一个在cur的左子树上一个在cur的右子树上，
13    //我们只需要返回cur结点即可。
14    return cur;
15}



public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
 2    //记录遍历到的每个节点的父节点。
 3    Map<TreeNode, TreeNode> parent = new HashMap<>();
 4    Queue<TreeNode> queue = new LinkedList<>();
 5    parent.put(root, null);//根节点没有父节点，所以为空
 6    queue.add(root);
 7    //直到两个节点都找到为止。
 8    while (!parent.containsKey(p) || !parent.containsKey(q)) {
 9        //队列是一边进一边出，这里poll方法是出队，
10        TreeNode node = queue.poll();
11        if (node.left != null) {
12            //左子节点不为空，记录下他的父节点
13            parent.put(node.left, node);
14            //左子节点不为空，把它加入到队列中
15            queue.add(node.left);
16        }
17        //右节点同上
18        if (node.right != null) {
19            parent.put(node.right, node);
20            queue.add(node.right);
21        }
22    }
23    Set<TreeNode> ancestors = new HashSet<>();
24    //记录下p和他的祖先节点，从p节点开始一直到根节点。
25    while (p != null) {
26        ancestors.add(p);
27        p = parent.get(p);
28    }
29    //查看p和他的祖先节点是否包含q节点，如果不包含再看是否包含q的父节点……
30    while (!ancestors.contains(q))
31        q = parent.get(q);
32    return q;
33}