// JZ44 翻转单词序列
// "nowcoder. a am I"
// "I am a nowcoder."
public class Solution {
    public String ReverseSentence(String str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        if(len < 2) {
            return str;
        }
        char[] chars = str.toCharArray();
        Reverse(chars, 0, len - 1);
        int pBegin = 0;
        int pEnd = 0;
       while (pBegin < len) {
            if (chars[pBegin] == ' ') {
                pBegin++;
                pEnd++;
            } else if (pEnd == len || chars[pEnd] == ' ' ) {
                Reverse(chars, pBegin, pEnd - 1);
                pBegin = ++pEnd;
            } else {
                pEnd++;
            }
        }
        return String.valueOf(chars);
    }
    public void Reverse(char[] chars, int begin, int end) {
        if (chars == null) {
            return;
        }
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            end--;
            begin++;
        }
    }
}