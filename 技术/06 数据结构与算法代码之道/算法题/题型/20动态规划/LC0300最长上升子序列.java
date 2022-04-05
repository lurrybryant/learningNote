public int lengthOfLIS(int[] nums) {
 2    //边界条件判断
 3    if (nums == null || nums.length == 0) {
 4        return 0;
 5    }
 6    int[] dp = new int[nums.length];
 7    //初始化数组dp的每个值为1
 8    Arrays.fill(dp, 1);
 9    int max = 1;
10    for (int i = 1; i < nums.length; i++) {
11        for (int j = 0; j < i; j++) {
12            //如果当前值nums[i]大于nums[j]，说明nums[i]可以和
13            //nums[j]结尾的上升序列构成一个新的上升子序列
14            if (nums[i] > nums[j]) {
15                dp[i] = Math.max(dp[i], dp[j] + 1);
16                //记录构成的最大值
17                max = Math.max(max, dp[i]);
18            }
19        }
20    }
21    return max;
22}