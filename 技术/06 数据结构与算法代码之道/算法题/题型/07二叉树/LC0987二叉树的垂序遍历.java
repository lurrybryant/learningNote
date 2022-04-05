public List<List<Integer>> verticalTraversal(TreeNode root) {
    //list集合中的元素是一个数组，每个数组的长度都是3，第1个值表示
    //节点的值，第2个和第3个值表示节点的横坐标和竖坐标
    List<int[]> mList = new ArrayList<>();
    //计算所有节点的值和坐标，根节点的坐标是（0，0）
    dfs(root, 0, 0, mList);
    //排序，排序的原则是先排左边一列，所以首先比较的是数组的第3个值（
    //纵坐标），然后每一列从上到下也就是数组的第2个值（横坐标），如果
    //前面两个值是一样的说明他们的坐标重合了，要按值从大到小排序
    Collections.sort(mList, (arr1, arr2) -> {
        //先按照纵坐标排序
        if (arr1[2] != arr2[2])
            return arr1[2] - arr2[2];
        if (arr1[1] != arr2[1])
            return arr1[1] - arr2[1];
        //如果坐标一样，再按照值排序
        return arr1[0] - arr2[0];
    });

    //把节点的值进行垂序分类
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    //因为上面排序了，所以这里首先遍历的就是最左边一列的值,
    //然后是第二列……
    for (int i = 0; i < mList.size(); i++) {
        //取出数组（包含当前节点的值和坐标）
        int[] arr = mList.get(i);
        //当前节点的值
        int value = arr[0];
        //如果当前节点和前一个节点不在同一列，说明到下一
        //列了，需要初始化下一列的集合
        if (i > 0 && arr[2] != mList.get(i - 1)[2])
            res.add(new ArrayList<>());
        //把当前节点的值添加到当前列中
        res.get(res.size() - 1).add(value);
    }
    return res;
}

private void dfs(TreeNode node, int i, int j, List<int[]> mList) {
    if (node == null)
        return;
    //把当前节点的值和坐标加入到集合中,当前节点的坐标是（i，j）
    mList.add(new int[]{node.val, i, j});
    //遍历左子节点
    dfs(node.left, i + 1, j - 1, mList);
    //遍历右子节点
    dfs(node.right, i + 1, j + 1, mList);
}


