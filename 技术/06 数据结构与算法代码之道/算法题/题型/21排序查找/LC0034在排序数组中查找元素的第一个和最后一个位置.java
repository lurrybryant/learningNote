public int[] searchRange(int[] nums, int target) {
 2    int first = searchFirst(nums, target);
 3    //判断有没有查找到
 4    if (first < nums.length && nums[first] == target) {
 5        int last = searchLast(nums, target);
 6        return new int[]{first, last};
 7    } else {
 8        //没有找到这个值，直接返回{-1, -1}
 9        return new int[]{-1, -1};
10    }
11}
12
13//如果数组nums中有多个target，那么返回值就是第一个出现的target的下标
14//如果数组nums中没有target，那么返回的就是第一个大于target的下标
15public static int searchFirst(int[] nums, double target) {
16    int low = 0, high = nums.length - 1;
17    while (low <= high) {
18        int m = low + (high - low) / 2;
19        if (target > nums[m])
20            low = m + 1;
21        else
22            high = m - 1;
23    }
24    return low;
25}
26
27public static int searchLast(int[] nums, double target) {
28    int low = 0, high = nums.length - 1;
29    while (low <= high) {
30        int m = low + (high - low) / 2;
31        if (target >= nums[m])
32            low = m + 1;
33        else
34            high = m - 1;
35    }
36    return high;
37}