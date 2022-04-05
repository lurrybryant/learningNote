String longestPalindrome(String s) {
 2    //边界条件判断
 3    if (s.length() < 2)
 4        return s;
 5    //start表示最长回文串开始的位置，
 6    //maxLen表示最长回文串的长度
 7    int start = 0, maxLen = 0;
 8    int length = s.length();
 9    for (int i = 0; i < length; ) {
10        //如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环
11        // （因为即使他是回文子串，也不是最长的，所以直接终止循环，不再判断）
12        if (length - i <= maxLen / 2)
13            break;
14        int left = i, right = i;
15        while (right < length - 1 && s.charAt(right + 1) == s.charAt(right))
16            ++right; //过滤掉重复的
17        //下次在判断的时候从重复的下一个字符开始判断
18        i = right + 1;
19        //然后往两边判断，找出回文子串的长度
20        while (right < length - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
21            ++right;
22            --left;
23        }
24        //保留最长的
25        if (right - left + 1 > maxLen) {
26            start = left;
27            maxLen = right - left + 1;
28        }
29    }
30    //截取回文子串
31    return s.substring(start, start + maxLen);
32}



