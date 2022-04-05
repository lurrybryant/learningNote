
public int rob(int[] nums) {
 2    if (nums.length == 0) return 0;
 3    int[] memo = new int[nums.length + 1];
 4    memo[0] = 0;
 5    memo[1] = nums[0];
 6    for (int i = 1; i < nums.length; i++) {
 7        int val = nums[i];
 8        memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
 9    }
10    return memo[nums.length];
11}