
















// JZ67 剪绳子
// 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
// 输入描述：
// 输入一个数n，意义见题面。（2 <= n <= 60）

    /**
     * @author yize
     * @param n 绳子长度
     * @return
     */
    public static int cutRope(int n) {
        if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }
        if(n%3==0){
            return (int)Math.pow(3,n/3);
        }else if(n%3==1){
            return 4*(int)Math.pow(3,n/3-1);
        }else {
            return 2*(int)Math.pow(3,n/3);
        }
    }
// 动态规划
public class Solution {
    public int cutRope(int target) {

        int result = 1;

        for (int i = 1; i <= target; i++) {
            int part = target / i; // 没部分的最小长度
            int term = target % i; //需要加长一的次数
            int plus = 1; //乘积中间值
            for (int j = 0; j < i; j++) {
                if (term-- > 0) {
                    plus *= part + 1;
                } else {
                    plus *= part;
                }
            }
            if (plus > result) {
                result = plus;
            } else {
                break;
            }
        }

        return result;
    }
}    





