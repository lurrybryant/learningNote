

// JZ49 把字符串转换成整数
public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int flag = 0;
        char[] chars = str.toCharArray();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                continue;
            } else if ( i == 0 && chars[i] == '+') {
                flag = 1; 
            } else if (i == 0 && chars[i] == '-') {
                flag = -1;
            } else {
                return 0;
            }
        }
        int index = 0;
        int result = 0;
        if (flag != 0) {
            index = 1;
        }
        int base = 1;
        for (int i = length - 1; i >= index; i--) {
            result += (chars[i] - '0')*base;
            base *= 10;
        }
        if (flag == -1) {
            result = -result;
        }
        return result;
    }
}
