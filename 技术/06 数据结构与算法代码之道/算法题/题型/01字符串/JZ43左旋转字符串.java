// JZ43 左旋转字符串，
// "abcXYZdef",3
// "XYZdefabc"

    // cbaXYZdef
    // cbafedzyx
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (n < 1 || n >= str.length()) {
            return str;
        }
        int len = str.length();
        char[] chars = str.toCharArray();
        Reverse(chars, 0, n - 1);
        Reverse(chars, n, len - 1);
        Reverse(chars, 0, len - 1);
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
