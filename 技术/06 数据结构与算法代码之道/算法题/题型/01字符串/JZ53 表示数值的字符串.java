

// JZ53 表示数值的字符串
// 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
import java.util.*;
import java.util.regex.Pattern;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @return bool布尔型
     */
    public boolean isNumeric (String str) {
        // write code here
//        ^表示开头 $ 表示结尾  java中两个\\ 代表一个\
//        * 零次或多次匹配前面的字符或子表达式 
//        ？零次或一次匹配前面的字符或子表达式
//        + 一次或多次匹配前面的字符或子表达式
//        [] 字符集。匹配包含的任一字符
//        (:? )匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配
        String p = "^[+-]?\\d*(?:\\.\\d*)?(?:[eE][+-]?\\d+)?$";
        return Pattern.matches(p,str);
    }
}