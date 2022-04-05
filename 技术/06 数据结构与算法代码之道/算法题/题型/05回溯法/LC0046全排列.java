public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<>(), nums);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
    //终止条件，如果数字都被使用完了，说明找到了一个排列，（可以把它看做是n叉树到
    //叶子节点了，不能往下走了，所以要返回）
    if (tempList.size() == nums.length) {
        //因为list是引用传递，这里必须要重新new一个
        list.add(new ArrayList<>(tempList));
        return;
    }
    //（可以把它看做是遍历n叉树每个节点的子节点）
    for (int i = 0; i < nums.length; i++) {
        //因为不能有重复的，所以有重复的就跳过
        if (tempList.contains(nums[i]))
            continue;
        //选择当前值
        tempList.add(nums[i]);
        //递归（可以把它看做遍历子节点的子节点）
        backtrack(list, tempList, nums);
        //撤销选择，把最后一次添加的值给移除
        tempList.remove(tempList.size() - 1);
    }
}



//递归解决
public List<List<Integer>> permute(int[] nums) {
    return helper(nums, 0);
}

/**
 * @param nums
 * @param index 递归当前数字的下标
 * @return
 */
private List<List<Integer>> helper(int[] nums, int index) {
    List<List<Integer>> res = new ArrayList<>();
    //递归的终止条件，如果到最后一个数组，直接把它放到res中
    if (index == nums.length - 1) {
        //创建一个临时数组
        List<Integer> temp = new ArrayList<>();
        //把数字nums[index]加入到临时数组中
        temp.add(nums[index]);
        res.add(temp);
        return res;
    }
    //计算后面数字的全排列
    List<List<Integer>> subList = helper(nums, index + 1);
    //集合中每个子集的长度
    int count = subList.get(0).size();
    //遍历集合subList的子集
    for (int i = 0, size = subList.size(); i < size; i++) {
        //把当前数字nums[index]添加到子集的每一个位置
        for (int j = 0; j <= count; j++) {
            List<Integer> temp = new ArrayList<>(subList.get(i));
            temp.add(j, nums[index]);
            res.add(temp);
        }
    }
    return res;
}