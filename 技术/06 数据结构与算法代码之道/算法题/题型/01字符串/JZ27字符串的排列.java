

// 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
// 输入描述:
// 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> re = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return re;
        }
        HashSet<String> set = new HashSet<String>();
        fun(set, str.toCharArray(), 0);
        re.addAll(set);
        Collections.sort(re);
        return re;
    }
    void fun(HashSet<String> re, char[] str, int beginIndex) {
        if (beginIndex == str.length) {
            //找到了一个字符串
            re.add(new String(str));
            return;
        }
        for (int i = beginIndex; i < str.length; i++) {
            swap(str, i, beginIndex);
            fun(re, str, beginIndex + 1);
            swap(str, i, beginIndex);
        }
    }
    void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}









