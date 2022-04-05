
// JZ52 正则表达式匹配
// 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
import java.util.*;
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @param pattern string字符串 
     * @return bool布尔型
     */
    public boolean match (String str, String pattern) {
        // write code here
        if(str==null || pattern==null){
            return false;
        }
        int strIndex=0;
        int patternIndex=0;
        char[] ch1=str.toCharArray();
        char[] ch2=pattern.toCharArray();
        return matchCore(ch1,ch2,strIndex,patternIndex);
    }

    public boolean matchCore(char[] str,char[] pattern,int strIndex,int patternIndex){
        if (strIndex==str.length && patternIndex==pattern.length) {
            return true;// 有效性检验：str到尾，pattern到尾，匹配ok
        }
        if(strIndex!=str.length && patternIndex==pattern.length){// pattern先到尾，匹配失败
            return false;
        }

        // 模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if(patternIndex+1<pattern.length && pattern[patternIndex+1]=='*'){
            if((strIndex!=str.length && pattern[patternIndex]==str[strIndex])||
               (pattern[patternIndex]=='.' && strIndex!=str.length)){
                return matchCore(str,pattern,strIndex,patternIndex+2)||
                    matchCore(str,pattern,strIndex+1,patternIndex+2)||
                    matchCore(str,pattern,strIndex+1,patternIndex);
            }
            else{
                return matchCore(str,pattern,strIndex,patternIndex+2);
            }
        }

        // 模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if((strIndex!=str.length && pattern[patternIndex]==str[strIndex]) || 
           (pattern[patternIndex]=='.' && strIndex!=str.length)){
            return matchCore(str,pattern,strIndex+1,patternIndex+1);
        }
        return false;
    }
}
