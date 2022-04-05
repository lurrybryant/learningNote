// 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
public class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return new String(sb);
    }
}



public String replaceSpace(StringBuffer str) {
    int m = str.length() - 1;
    while (m >= 0) {
        if (str.substring(m, m + 1).equals(" ")) {
            str.replace(m, m + 1, "%20");
        }
        m--;
    }
    return str.toString();
}