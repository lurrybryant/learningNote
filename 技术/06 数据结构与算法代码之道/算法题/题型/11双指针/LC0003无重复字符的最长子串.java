// 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0)
        return 0;
    HashMap<Character, Integer> map = new HashMap<>();
    int max = 0;
    for (int i = 0, j = 0; i < s.length(); ++i) {
        //如果有重复的，就修改j的值
        if (map.containsKey(s.charAt(i))) {
            j = Math.max(j, map.get(s.charAt(i)) + 1);
        }
        map.put(s.charAt(i), i);
        //记录查找的最大值
        max = Math.max(max, i - j + 1);
    }
    //返回最大值
    return max;
}
