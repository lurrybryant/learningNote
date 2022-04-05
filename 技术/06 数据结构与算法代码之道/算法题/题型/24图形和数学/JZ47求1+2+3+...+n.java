// JZ47 求1+2+3+...+n
public class Solution {
    public int Sum_Solution(int n) {
        int result = n;
        int temp = 0;
        boolean decide = (n > 0) && temp == (result += Sum_Solution(n - 1));
        return result;
    }
}