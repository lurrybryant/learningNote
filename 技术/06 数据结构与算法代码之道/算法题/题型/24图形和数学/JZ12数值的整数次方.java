// 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
// 保证base和exponent不同时为0
public class Solution {
    public double Power(double base, int exponent) {
        int n = Math.abs(exponent);
        double ret = 1.0;
        if (n == 0) {
            return ret;
        }
        ret = Power(base, n>>1);
        ret *= ret;
        if ((n & 1)== 1) {
            ret *= base;
        }
        if (exponent < 0) {
            ret = 1 / ret;
        }
        return ret;
  }
}
