// 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
public class Solution {
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        int ret = 0;
        for (int i = 3; i <= target; i++) {
            ret = f1 + f2;
            f1 = f2;
            f2 = ret;
        }
        return ret;
    }
}



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


// 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        if (n > 0 && n < 10) {
            return 1;
        }
        int num = n;
        int base = 1;
        int digit = 0;
        do {
            num /= 10; 
            base *= 10;
            digit++;
        } while (num > 9);
        int other = n - num * base;
        int numFirstDigit = 0;
        if (num > 1) {
            numFirstDigit = base;
        } else {
            numFirstDigit = other + 1;
        }
        int numOtherDigits = num * digit * base / 10;
        int recursiveDigit = NumberOf1Between1AndN_Solution(other);
        return numOtherDigits + numFirstDigit + recursiveDigit;
    }
}






