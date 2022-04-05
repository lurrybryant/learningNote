 public int rob(int[] nums) {
 2    if (nums.length == 1)
 3        return nums[0];
 4    //可以偷第一家，但不能偷最后一家
 5    int robFirst = robHelper(nums, 0, nums.length - 2);
 6    //可以偷最后一家，但不能偷第一家
 7    int robLast = robHelper(nums, 1, nums.length - 1);
 8    //选择偷第1家和不偷第1家结果的最大值
 9    return Math.max(robFirst, robLast);
10}
11
12 private int robHelper(int[] num, int start, int end) {
13    int steal = 0, noSteal = 0;
14    for (int j = start; j <= end; j++) {
15        int temp = steal;
16        steal = noSteal + num[j];
17        noSteal = Math.max(noSteal, temp);
18    }
19    return Math.max(steal, noSteal);
20}